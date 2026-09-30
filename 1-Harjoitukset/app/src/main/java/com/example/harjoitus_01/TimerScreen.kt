package com.example.harjoitus_01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TimerScreen(
    timerViewModel: TimerViewModel = viewModel()
) {
    val seconds by timerViewModel.seconds
        .collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(R.string.timer_value_format, seconds)
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Button(
                onClick = {
                    timerViewModel.startTimer()
                }
            ) {
                Text(stringResource(R.string.action_start))
            }

            Button(
                onClick = {
                    timerViewModel.stopTimer()
                }
            ) {
                Text(stringResource(R.string.action_stop))
            }

            Button(
                onClick = {
                    timerViewModel.resetTimer()
                },
                enabled = seconds > 0
            ) {
                Text(stringResource(R.string.action_reset))
            }
        }
    }
}
