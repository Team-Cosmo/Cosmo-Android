package kw.team.network.gpt

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GptResponseDto(
    @SerialName("choices")
    val choices: List<ChoiceResponseDto>,
) {

    @Serializable
    data class ChoiceResponseDto(
        @SerialName("delta")
        val messageResponseDto: MessageResponseDto,
    ) {

        @Serializable
        data class MessageResponseDto(
            @SerialName("content")
            val content: String? = "",
        )
    }
}

// logprobs: 단어별 신뢰도
// refusal: 윤리 등 GPT 자체적인 응답 거부
// finish_reason: GPT 통신 이슈
