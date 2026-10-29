package com.example.harjoitus_01.ui.counter

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.harjoitus_01.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CounterViewModelScreen(
    counterViewModel: CounterViewModel = viewModel(),
    onBackClick: (() -> Unit)? = null,
) {
    val count by counterViewModel.count.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.portfolio_counter_title))
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.counter_value, count)
            )

            Spacer(
                modifier = Modifier.height(24.dp)
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Button(
                    onClick = {
                        counterViewModel.decrease()
                    }, enabled = count > 0
                ) {
                    Text(
                        text = stringResource(R.string.action_decrease)
                    )
                }
                Button(
                    onClick = {
                        counterViewModel.increase()
                    }
                ) {
                    Text(
                        text = stringResource(R.string.action_increase)
                    )
                }
                Button(
                    onClick = {
                        counterViewModel.reset()
                    }
                ) {
                    Text(
                        text = stringResource(R.string.action_reset)
                    )
                }
            }
        }
    }
}
