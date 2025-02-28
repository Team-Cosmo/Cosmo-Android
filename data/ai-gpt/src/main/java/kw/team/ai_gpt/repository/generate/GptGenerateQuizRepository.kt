package kw.team.ai_gpt.repository.generate

import kotlinx.coroutines.flow.StateFlow
import kw.team.ai.repository.GenerateQuizRepository
import kw.team.network.source.GptRemoteDataSource
import javax.inject.Inject

class GptGenerateQuizRepository @Inject constructor(
    private val gptRemoteDataSource: GptRemoteDataSource,
    // private val gptLocalDataSource: GptLocalDataSource,
) : GenerateQuizRepository {
    override val reply: StateFlow<String> = gptRemoteDataSource.reply

    override suspend fun fetchQuiz() {
        gptRemoteDataSource.fetchQuiz()
    }
}
