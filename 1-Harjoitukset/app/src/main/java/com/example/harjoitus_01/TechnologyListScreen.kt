package com.example.harjoitus_01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Switch
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TechnologyListScreen(
    modifier: Modifier = Modifier
) {
    var showFavoritesOnly by rememberSaveable {
        mutableStateOf(false)
    }

    val visibleTechnologies = if (showFavoritesOnly) {
        ProgrammingTechnologies.filter {
            it.isFavorite
        }
    } else {
        ProgrammingTechnologies
    }

    Scaffold(
        modifier = modifier, topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.technology_screen_title)
                    )
                })
        }) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),

            contentPadding = PaddingValues(16.dp),

            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = stringResource(R.string.technology_show_favorites)
                    )

                    Switch(
                        checked = showFavoritesOnly, onCheckedChange = { checked ->
                            showFavoritesOnly = checked
                        })
                }
            }

            if (visibleTechnologies.isEmpty()) {

                item {
                    Text(
                        text = stringResource(R.string.technology_no_favorites)
                    )
                }

            } else {

                items(
                    items = visibleTechnologies, key = { technology ->
                        technology.id
                    }) { technology ->

                    ProgrammingTechnologyCard(
                        technology = technology
                    )
                }
            }
        }
    }
}