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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import java.util.Locale

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

    val invalidNumberError = stringResource(R.string.converter_error_invalid_number)
    val inchesUnitFormat = stringResource(R.string.converter_result)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = stringResource(R.string.converter_title),
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
                Text(text = stringResource(R.string.converter_label_centimeters))
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
                    errorMessage = invalidNumberError
                    result = ""
                } else {
                    val inches = convertCentimetersToInches(centimeters)
                    result = String.format(Locale.getDefault(), inchesUnitFormat, inches)
                    errorMessage = ""
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.action_calculate))
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
            Text(text = stringResource(R.string.action_clear))
        }

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        if (result.isNotEmpty()) {
            Text(
                text = stringResource(R.string.converter_result_prefix, result),
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
                    stringResource(R.string.action_hide_help)
                } else {
                    stringResource(R.string.action_show_help)
                }
            )
        }

        if (showFormula) {
            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Text(
                text = stringResource(R.string.converter_formula)
            )
        }
    }
}
