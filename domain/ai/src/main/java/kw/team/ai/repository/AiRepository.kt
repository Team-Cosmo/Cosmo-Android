package kw.team.ai.repository

import kotlinx.coroutines.flow.StateFlow

abstract class AiRepository(
    val chatRepository: ChatRepository,
    val generateQuizRepository: GenerateQuizRepository? = null,
) {

    suspend fun fetchMessage(message: String) {
        chatRepository.fetchMessage(message)
    }

    suspend fun fetchQuiz() {
        if (generateQuizRepository == null) return
        generateQuizRepository.fetchQuiz()
    }
}

interface ChatRepository {
    val reply: StateFlow<String>

    suspend fun fetchMessage(message: String)
}

interface GenerateQuizRepository {
    val reply: StateFlow<String>

    suspend fun fetchQuiz()
}
