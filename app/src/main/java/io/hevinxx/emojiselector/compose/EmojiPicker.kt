package io.hevinxx.emojiselector.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@ExperimentalFoundationApi
@Preview
@Composable
fun EmojiPicker() {
    val emojis = (0x1F600..0x1F64F).map {
        String(Character.toChars(it))
    }
    LazyVerticalGrid(
        cells = GridCells.Fixed(7),
    ) {
        items(emojis.size) { index ->
            Box() {
                Text(emojis[index])
            }
        }
    }
}

fun openEmojiPicker() {

}