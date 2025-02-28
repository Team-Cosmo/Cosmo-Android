package kw.team.main.model

data class ChatModel(
    val isMe: Boolean = false,
    val message: String = "무엇을 도와드릴까요?",
)
