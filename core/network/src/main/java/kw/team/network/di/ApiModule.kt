package kw.team.network.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import kw.team.network.claude.ClaudeApi
import kw.team.network.gpt.GptApi
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    private const val GPT_BASE_URL = "https://api.openai.com/"
    private const val CLAUDE_BASE_URL = "https://api.anthropic.com/"

    @Provides
    @Singleton
    fun provideGptApi(
        okHttpClient: OkHttpClient,
        converter: Converter.Factory,
    ): GptApi = Retrofit.Builder()
        .baseUrl(GPT_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(converter)
        .build()
        .create()

    @Provides
    @Singleton
    fun provideClaudeApi(
        okHttpClient: OkHttpClient,
        converter: Converter.Factory,
    ): ClaudeApi = Retrofit.Builder()
        .baseUrl(CLAUDE_BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(converter)
        .build()
        .create()

    @Provides
    @Singleton
    internal fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = BODY
        }

    @Provides
    @Singleton
    internal fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    @Provides
    @Singleton
    internal fun provideConverterFactory(json: Json): Converter.Factory =
        json.asConverterFactory("application/json".toMediaType())
}
