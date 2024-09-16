package ru.godsonpeya.bpmn

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ChantListScreen(
    chants: List<String>,
    currentChantIndex: Int,
    onChantClick: (Int) -> Unit
) {
    val listState = rememberLazyListState()

    LaunchedEffect(currentChantIndex) {
        listState.animateScrollToItem(currentChantIndex)
    }

    LazyColumn(state = listState) {
        items(chants) { chant ->
            ChantItem(chant = chant) {
                onChantClick(chants.indexOf(chant))
            }
        }
    }
}

@Composable
fun ChantItem(chant: String, onClick: () -> Unit) {
    Text(
        text = chant,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(onClick = onClick)
    )
}