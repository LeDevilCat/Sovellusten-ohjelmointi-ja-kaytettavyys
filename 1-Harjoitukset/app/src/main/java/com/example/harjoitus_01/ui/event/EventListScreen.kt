package com.example.harjoitus_01.ui.event

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harjoitus_01.R
import com.example.harjoitus_01.ui.theme.Harjoitus01Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventListScreen(
    modifier: Modifier = Modifier,
    onEventClick: (Int) -> Unit,
    onBackClick: (() -> Unit)? = null,
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
                    Text(text = stringResource(R.string.events_screen_title))
                },
                navigationIcon = {
                    onBackClick?.let { onClick ->
                        IconButton(onClick = onClick) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.action_back)
                            )
                        }
                    }
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
                        Text(text = stringResource(R.string.events_search_label))
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
                    Text(text = stringResource(R.string.events_show_free_only))
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
                    Text(
                        text = stringResource(R.string.events_no_results),
                        modifier = Modifier.padding(top = 16.dp)
                    )
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

@Preview(showBackground = true)
@Composable
fun EventListScreenPreview() {
    Harjoitus01Theme {
        EventListScreen(
            onEventClick = {},
            onBackClick = {}
        )
    }
}
