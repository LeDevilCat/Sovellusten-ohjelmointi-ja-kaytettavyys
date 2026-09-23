package com.example.harjoitus_01

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harjoitus_01.ui.theme.Harjoitus01Theme

@Composable
fun ProfileHeader(
    name: String,
    role: String,
    description: String
) {
    Column {
        Text(
            text = name,
            style = MaterialTheme.typography.headlineMedium
        )

        Text(
            text = role,
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileHeaderPreview() {
    Harjoitus01Theme {
        ProfileHeader(
            name = "Matti Meikäläinen",
            role = "Ohjelmistokehittäjä",
            description = "Rakennan sovelluksia ja olen kiinnostunut ohjelmoinnista."
        )
    }
}