package io.hevinxx.emojiselector

import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun EmojiSelector(
    content: @Composable () -> Unit = { DefaultView() },
    onEmojiSelected: (selectedEmoji: String) -> Unit = {},
) {
    content()
}

@Composable
fun DefaultView() {
    Card(
        backgroundColor = Color.White,
    ) {
        Text(
            text = "😀",
        )
    }
}