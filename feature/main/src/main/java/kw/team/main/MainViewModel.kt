package kw.team.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kw.team.ai.model.AiModel
import kw.team.ai.repository.ChatRepository
import kw.team.ai.repository.GenerateQuizRepository
import kw.team.ai.usecase.GetReplyUseCase
import kw.team.main.model.ChatModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    getReplyUseCase: GetReplyUseCase,
    private val chatRepository: ChatRepository,
    private val generateQuizRepository: GenerateQuizRepository,
) : ViewModel() {
    val aiModels: List<AiModel> get() = AiModel.entries.toList()

    private val _gptChatLog: MutableStateFlow<List<ChatModel>> =
        MutableStateFlow(listOf(ChatModel()))
    val gptChatLog: StateFlow<List<ChatModel>> get() = _gptChatLog.asStateFlow()

    private val _claudeChatLog: MutableStateFlow<List<ChatModel>> =
        MutableStateFlow(listOf(ChatModel()))
    val claudeChatLog: StateFlow<List<ChatModel>> get() = _claudeChatLog.asStateFlow()

    init {
        viewModelScope.launch {
            getReplyUseCase().collect { reply ->
                if (reply.isNotEmpty()) {
                    _gptChatLog.update { currentLog ->
                        val lastMessage = currentLog.lastOrNull()
                        when (lastMessage != null && lastMessage.isMe.not()) {
                            true -> currentLog.dropLast(1) + lastMessage.copy(message = reply)
                            false -> currentLog + ChatModel(isMe = false, message = reply)
                        }
                    }
                }
            }
        }
    }
// 지피티랑 클로드 채팅 전환 기능 구현하기.
    fun converseWith(message: String) {
        _gptChatLog.update { currentLog ->
            currentLog + ChatModel(
                isMe = true,
                message = message,
            )
        }

        viewModelScope.launch {
            chatRepository.fetchMessage(message)
        }
    }

    fun ask(question: String) {
        _gptChatLog.update {
            emptyList()
        }

        viewModelScope.launch {
            generateQuizRepository.fetchQuiz()
        }
    }
}

// 1. Stream 구현
// 2. 채팅 UI 정상 구현
// 3. 룸 구현
// 4. 캐싱 구현
// 5. 에러일 때 대응
// 6. Claude 구현
// 7. 스레드 관리
// 문제 생성 시 logprobs 값 비교하기
