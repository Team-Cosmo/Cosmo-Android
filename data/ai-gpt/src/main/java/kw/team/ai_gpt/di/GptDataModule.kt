package kw.team.ai_gpt.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kw.team.ai.repository.AiRepository
import kw.team.ai.repository.ChatRepository
import kw.team.ai.repository.GenerateQuizRepository
import kw.team.ai_gpt.repository.DefaultGptAiRepository
import kw.team.ai_gpt.repository.chat.GptChatRepository
import kw.team.ai_gpt.repository.generate.GptGenerateQuizRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class GptDataModule {

    @Binds
    @Singleton
    internal abstract fun bindGptAiRepository(
        defaultGptAiRepository: DefaultGptAiRepository,
    ): AiRepository

    @Binds
    @Singleton
    internal abstract fun bindGptChatRepository(
        gptChatRepository: GptChatRepository,
    ): ChatRepository

    @Binds
    @Singleton
    internal abstract fun bindGptGenerateQuizRepository(
        gptGenerateQuizRepository: GptGenerateQuizRepository,
    ): GenerateQuizRepository
}
