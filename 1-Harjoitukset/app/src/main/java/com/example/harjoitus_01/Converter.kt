package com.example.harjoitus_01

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun convertCentimetersToInches(
    centimeters: Double
): Double {
    return centimeters / 2.54
}

@Composable
fun Converter() {

    var input by rememberSaveable {
        mutableStateOf("")
    }

    var result by rememberSaveable {
        mutableStateOf("")
    }

    var errorMessage by rememberSaveable {
        mutableStateOf("")
    }

    var showFormula by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Senttimetri–tuuma-muunnin",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedTextField(
            value = input,
            onValueChange = {
                input = it
                errorMessage = ""
            },
            label = {
                Text(text = "Senttimetrit")
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = {

                val centimeters = input
                    .replace(',', '.')
                    .toDoubleOrNull()

                if (centimeters == null) {
                    errorMessage = "Anna kelvollinen numero."
                    result = ""
                } else {
                    val inches = convertCentimetersToInches(centimeters)
                    result = "%.2f tuumaa".format(inches)
                    errorMessage = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Laske")
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        OutlinedButton(
            onClick = {
                input = ""
                result = ""
                errorMessage = ""
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Tyhjennä")
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        if (result.isNotEmpty()) {
            Text(
                text = "Tulos: $result",
                style = MaterialTheme.typography.titleLarge
            )
        }

        if (errorMessage.isNotEmpty()) {
            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error
            )
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        OutlinedButton(
            onClick = {
                showFormula = !showFormula
            }
        ) {
            Text(
                text = if (showFormula) {
                    "Piilota ohje"
                } else {
                    "Näytä ohje"
                }
            )
        }

        if (showFormula) {
            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = "Muunnos tehdään kaavalla: tuumat = senttimetrit / 2,54"
            )
        }
    }
}