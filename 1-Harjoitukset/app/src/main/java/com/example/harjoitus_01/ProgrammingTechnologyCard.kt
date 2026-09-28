package com.example.harjoitus_01

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun ProgrammingTechnologyCard(
    technology: ProgrammingTechnology,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.programming),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = technology.name,
                style = MaterialTheme.typography.headlineMedium
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Text(
                text = technology.description,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Text(
                text = "Kokemusta: ${technology.experienceYears} vuotta"
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            Row {
                Text(
                    text = if (technology.isFavorite) {
                        "✅ Suosikki"
                    } else {
                        "🟥 Ei Suosikki"
                    }
                )
            }
        }
    }
}