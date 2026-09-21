package com.example.harjoitus_01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RegistrationScreen() {

    var name by rememberSaveable {
        mutableStateOf("")
    }

    var participantCount by rememberSaveable {
        mutableStateOf(1)
    }

    var isConfirmed by rememberSaveable {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Tapahtumaan ilmoittautuminen",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = name,
            onValueChange = { newName ->
                name = newName
                isConfirmed = false
            },
            label = {
                Text(text = "Nimi")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        ParticipantSelector(
            participantCount = participantCount,
            onIncrease = {
                participantCount++
                isConfirmed = false
            },
            onDecrease = {
                participantCount--
                isConfirmed = false
            }
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {
                isConfirmed = true
            },
            enabled = name.isNotBlank(),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Vahvista")
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        if (isConfirmed) {
            RegistrationSummary(
                name = name,
                participantCount = participantCount
            )
        }
    }
}


@Composable
fun ParticipantSelector(
    participantCount: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Osallistujamäärä",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            OutlinedButton(
                onClick = onDecrease,
                enabled = participantCount > 1
            ) {
                Text(text = "-")
            }

            Text(
                text = "$participantCount",
                style = MaterialTheme.typography.headlineMedium
            )

            OutlinedButton(
                onClick = onIncrease,
                enabled = participantCount < 5
            ) {
                Text(text = "+")
            }
        }
    }
}


@Composable
fun RegistrationSummary(
    name: String,
    participantCount: Int
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Ilmoittautuminen vahvistettu!",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Nimi: $name"
        )

        Text(
            text = "Osallistujamäärä: $participantCount"
        )
    }
}