package kw.team.main.component


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.End
import androidx.compose.foundation.layout.Arrangement.Start
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kw.team.designsystem.theme.CosmoTheme
import kw.team.designsystem.theme.CosmoTheme.colors
import kw.team.designsystem.theme.CosmoTheme.typography
import kw.team.main.model.ChatModel

@Composable
internal fun MainAiChatLazyColumn(
    messages: List<ChatModel>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(space = 20.dp),
        modifier = modifier,
    ) {
        items(messages) { chatModel ->
            MainAiChatItem(chatModel)
        }
    }
}

@Composable
private fun MainAiChatItem(
    chatModel: ChatModel,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = if (chatModel.isMe) End else Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = if (chatModel.isMe) 20.dp else 0.dp,
                end = if (!chatModel.isMe) 20.dp else 0.dp,
            ),
    ) {
        Text(
            text = chatModel.message,
            style = typography.body14R,
            color = if (chatModel.isMe) colors.onBackground else colors.background,
            modifier = Modifier
                .background(
                    color = if (chatModel.isMe) colors.background else colors.primary,
                    shape = RoundedCornerShape(size = 16.dp),
                )
                .padding(all = 12.dp),
        )
    }
}

@Preview
@Composable
private fun MainAiChatLazyColumnPreview() {
    CosmoTheme {
        MainAiChatLazyColumn(
            messages = emptyList(),
        )
    }
}

@Preview
@Composable
private fun MainAiChatItemPreview() {
    CosmoTheme {
        MainAiChatItem(
            chatModel = ChatModel(
                isMe = true,
                message = "",
            )
        )
    }
}
