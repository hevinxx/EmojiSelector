package io.hevinxx.emojiselector

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.hevinxx.emojiselector.view.openEmojiPicker

@Preview
@Composable
fun EmojiSelector(
    onEmojiSelected: (selectedEmoji: String) -> Unit = {},
    content: @Composable () -> Unit = { DefaultView() },
) {
    Box(
        modifier = Modifier.clickable {
            openEmojiPicker()
        }
    ) {
        content()
    }
}

@Composable
fun DefaultView() {
    Card(
        border = BorderStroke(2.dp, Color.White),
        backgroundColor = Color.Transparent,
    ) {
        Text(
            text = "😀+",
            modifier = Modifier.padding(2.dp),
        )
    }
}