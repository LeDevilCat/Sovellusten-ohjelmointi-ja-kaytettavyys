package com.example.harjoitus_01.ui.portfolio

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harjoitus_01.R
import com.example.harjoitus_01.ui.theme.Harjoitus01Theme

data class PortfolioFeature(
    val title: String,
    val description: String,
    val onClick: () -> Unit,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PortfolioScreen(
    onEventsClick: () -> Unit,
    onTechnologiesClick: () -> Unit,
    onCounterClick: () -> Unit,
    onTimerClick: () -> Unit,
    onConverterClick: () -> Unit,
    onRegistrationClick: () -> Unit,
    onWebsiteClick: () -> Unit,
    onBackClick: (() -> Unit)? = null,
) {
    val features = listOf(
        PortfolioFeature(
            title = stringResource(R.string.portfolio_events_title),
            description = stringResource(R.string.portfolio_events_description),
            onClick = onEventsClick,
        ),
        PortfolioFeature(
            title = stringResource(R.string.portfolio_technologies_title),
            description = stringResource(R.string.portfolio_technologies_description),
            onClick = onTechnologiesClick,
        ),
        PortfolioFeature(
            title = stringResource(R.string.portfolio_counter_title),
            description = stringResource(R.string.portfolio_counter_description),
            onClick = onCounterClick,
        ),
        PortfolioFeature(
            title = stringResource(R.string.portfolio_timer_title),
            description = stringResource(R.string.portfolio_timer_description),
            onClick = onTimerClick,
        ),
        PortfolioFeature(
            title = stringResource(R.string.portfolio_converter_title),
            description = stringResource(R.string.portfolio_converter_description),
            onClick = onConverterClick,
        ),
        PortfolioFeature(
            title = stringResource(R.string.portfolio_registration_title),
            description = stringResource(R.string.portfolio_registration_description),
            onClick = onRegistrationClick,
        ),
        PortfolioFeature(
            title = stringResource(R.string.portfolio_website_title),
            description = stringResource(R.string.portfolio_website_description),
            onClick = onWebsiteClick,
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.portfolio_title)
                    )
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
            items(
                items = features,
                key = { feature -> feature.title }
            ) { feature ->
                PortfolioFeatureCard(
                    title = feature.title,
                    description = feature.description,
                    onClick = feature.onClick
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PortfolioScreenPreview() {
    Harjoitus01Theme {
        PortfolioScreen(
            onEventsClick = {},
            onTechnologiesClick = {},
            onCounterClick = {},
            onTimerClick = {},
            onConverterClick = {},
            onRegistrationClick = {},
            onWebsiteClick = {}
        )
    }
}
