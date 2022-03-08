package io.hevinxx.emojiselector.compose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@Preview
@Composable
fun EmojiSelector(
    onEmojiSelected: (selectedEmoji: String) -> Unit = {},
    content: @Composable () -> Unit = { DefaultView() },
) {
    val emojis = (0x1F600..0x1F64F).map {
        String(Character.toChars(it))
    }
    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()
    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = {
            LazyVerticalGrid(
                cells = GridCells.Fixed(7),
            ) {
                items(emojis.size) { index ->
                    Box(
                        modifier = Modifier.clickable {
                            onEmojiSelected(emojis[index])
                        }
                    ) {
                        Text(emojis[index])
                    }
                }
            }
        },
        sheetPeekHeight = 0.dp,
    ) {
        Box(
            modifier = Modifier.clickable {
                coroutineScope.launch {
                    if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                        bottomSheetScaffoldState.bottomSheetState.expand()
                    } else {
                        bottomSheetScaffoldState.bottomSheetState.collapse()
                    }
                }
            }
        ) {
            content()
        }
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