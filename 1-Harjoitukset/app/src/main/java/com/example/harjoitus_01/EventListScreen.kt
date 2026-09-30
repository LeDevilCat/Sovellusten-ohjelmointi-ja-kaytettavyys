package com.example.harjoitus_01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(
    modifier: Modifier = Modifier,
    onEventClick: (Int) -> Unit
) {
    var showFreeOnly by rememberSaveable {
        mutableStateOf(false)
    }
    var searchText by rememberSaveable {
        mutableStateOf("")
    }

    val visibleEvents = Events.filter { event ->
        val matchFreeFilter = !showFreeOnly || event.isFree
        val matchSearchText = event.name.contains(searchText, ignoreCase = true) ||
                event.location.contains(searchText, ignoreCase = true)
        matchFreeFilter && matchSearchText
    }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Tapahtumat")
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                OutlinedTextField(
                    value = searchText,
                    onValueChange = { newText ->
                        searchText = newText
                    },
                    label = {
                        Text(text = "Hae tapahtumaa tai sijaintia")
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Näytä vain ilmaiset")
                    Switch(
                        checked = showFreeOnly,
                        onCheckedChange = { checked ->
                            showFreeOnly = checked
                        }
                    )
                }
            }

            if (visibleEvents.isEmpty()) {
                item {
                    Text(text = "Hakuehdoilla ei löytynyt tapahtumia.")
                }
            } else {
                items(
                    items = visibleEvents,
                    key = { event -> event.id }
                ) { event ->
                    EventCard(
                        event = event,
                        onClick = {
                            onEventClick(event.id)
                        }
                    )
                }
            }
        }
    }
}
