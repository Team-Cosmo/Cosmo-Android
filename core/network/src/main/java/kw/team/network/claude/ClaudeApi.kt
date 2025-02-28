package kw.team.network.claude

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ClaudeApi {

    @POST("v1/messages")
    suspend fun postMessage(
        @Header("x-api-key") header1: String,
        @Header("anthropic-version") header2: String,
        @Body claudeRequestDto: ClaudeRequestDto,
    ): ClaudeResponseDto
}

@Serializable
data class ClaudeRequestDto(

    @SerialName("model")
    val model: String,
    @SerialName("max_tokens")
    val max_tokens: Int,
    @SerialName("messages")
    val messages: List<Message>,
) {

    @Serializable
    data class Message(
        @SerialName("role")
        val role: String,
        @SerialName("content")
        val content: String,
    )
}

@Serializable
data class ClaudeResponseDto(
    @SerialName("content")
    val content: List<Content>,
    @SerialName("id")
    val id: String,
    @SerialName("model")
    val model: String,
    @SerialName("role")
    val role: String,
    @SerialName("stop_reason")
    val stop_reason: String,
    @SerialName("stop_sequence")
    val stop_sequence: String?,
    @SerialName("type")
    val type: String,
    @SerialName("usage")
    val usage: Usage,
) {

    @Serializable
    data class Usage(
        @SerialName("input_tokens")
        val input_tokens: Int,
        @SerialName("output_tokens")
        val output_tokens: Int,
    )

    @Serializable
    data class Content(
        @SerialName("text")
        val text: String,
        @SerialName("type")
        val type: String,
    )
}
