package kw.team.network.source

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.isActive
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import kw.team.common.di.Dispatcher
import kw.team.common.di.DispatcherType
import kw.team.network.gpt.GptApi
import kw.team.network.gpt.GptRequestDto
import kw.team.network.gpt.GptRequestDto.GptMessageRequestDto
import kw.team.network.gpt.GptResponseDto
import kw.team.network.source.GptRemoteDataSource.Role.ASSISTANT
import kw.team.network.source.GptRemoteDataSource.Role.SYSTEM
import kw.team.network.source.GptRemoteDataSource.Role.USER
import java.io.InputStream
import java.util.Locale
import javax.inject.Inject

class GptRemoteDataSource @Inject constructor(
    private val gptApi: GptApi,
    @Dispatcher(DispatcherType.IO) private val ioDispatcher: CoroutineDispatcher,
) {
    @Inject
    internal lateinit var json: Json

    private val _reply: MutableStateFlow<String> = MutableStateFlow("")
    val reply: StateFlow<String> get() = _reply.asStateFlow()

    private val messageLog: MutableList<GptMessageRequestDto> = mutableListOf(SYSTEM_INIT_MESSAGE)

    private val replyBuilder by lazy { StringBuilder() }

    private val defaultGptRequestDto by lazy {
        GptRequestDto(
            model = GPT_MODEL,
            messages = messageLog,
            stream = IS_STREAMING,
        )
    }

    suspend fun fetchMessage(message: String) {
        updateMessageLog(role = USER, message = message)
        val messageStream: InputStream = gptApi
            .postMessage(gptRequestDto = defaultGptRequestDto.copy(messages = messageLog))
            .byteStream()
        processStream(messageStream)
        updateMessageLog(role = ASSISTANT, message = reply.value)
    }

    suspend fun fetchQuiz() {
        updateMessageLog(role = USER, message = SYSTEM_INIT_MESSAGE_QUIZ)
        val messageStream: InputStream = gptApi
            .postMessage(gptRequestDto = defaultGptRequestDto.copy(messages = messageLog))
            .byteStream()
        processStream(messageStream)
    }

    private suspend fun processStream(stream: InputStream) {
        withContext(ioDispatcher) {
            stream.bufferedReader().use { reader ->
                while (currentCoroutineContext().isActive) {
                    val response = reader.readLine().orEmpty()

                    when {
                        response.contains(STREAM_END_SIGN) -> break
                        response.startsWith(STREAM_START_SIGN) -> {
                            response.decode().also { decodedContent ->
                                replyBuilder.append(decodedContent)
                                _reply.update { replyBuilder.toString() }
                            }
                        }

                        else -> continue
                    }
                    delay(100)
                }
            }
        }
    }

    private fun updateMessageLog(role: Role, message: String) {
        messageLog.add(
            GptMessageRequestDto(
                role = role.toString(),
                content = message,
            )
        )
    }

    private fun String.decode(): String = json.decodeFromString<GptResponseDto>(
        substring(STREAM_START_SIGN.length).trim()
    ).choices.first().messageResponseDto.content.orEmpty()

    private enum class Role {
        USER, SYSTEM, ASSISTANT,
        ;

        override fun toString(): String = name.lowercase(Locale.ROOT)
    }

    companion object {
        private const val STREAM_START_SIGN = "data:"
        private const val STREAM_END_SIGN = "[DONE]"
        private const val GPT_MODEL = "gpt-4o-mini"
        private const val IS_STREAMING = true
        private val SYSTEM_INIT_MESSAGE = GptMessageRequestDto(
            role = SYSTEM.toString(),
            content = "한글로 해줘",
        )
        private val SYSTEM_INIT_MESSAGE_QUIZ = """
            다음 조건에 맞게 CS 예상 면접 질문 10문제를 생성해줘.
            1. 질문은 최대 40글자이다.
            2. 각 답변은 최대 50글자이다.
            3. 4지선다형이다.
            4. 다음 양식에 맞춰서 준다.
            question: String,
            choices: List<String>,
            answerIndex: Int,
            5. 한 문제가 끝나면, `\n\n` 문자를 삽입 후 다음 문제를 생성한다.
        """.trimIndent()
    }
}
