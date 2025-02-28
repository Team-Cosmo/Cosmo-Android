package kw.team.network.gpt

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GptRequestDto(
    @SerialName("model")
    val model: String,
    @SerialName("messages")
    val messages: List<GptMessageRequestDto>,
    @SerialName("stream")
    val stream: Boolean,
) {

    @Serializable
    data class GptMessageRequestDto(
        @SerialName("role")
        val role: String,
        @SerialName("content")
        val content: String,
    )
}
