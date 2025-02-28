package kw.team.ai.usecase

import kotlinx.coroutines.flow.Flow
import kw.team.ai.repository.ChatRepository
import javax.inject.Inject

class GetReplyUseCase @Inject constructor(
    private val chatRepository: ChatRepository,
) {

    operator fun invoke(): Flow<String> = chatRepository.reply
}
