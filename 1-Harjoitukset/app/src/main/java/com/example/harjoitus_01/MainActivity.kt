package com.example.harjoitus_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

import com.example.harjoitus_01.ui.theme.Harjoitus01Theme


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            Harjoitus01Theme {
                // aseta käyttöliittymän pääkomponentti
                // käyttöliittymö on Composable funktio
                // Composable on funktio, joka palauttaa käyttöliittymän
                ProfileScreen()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.profile_title)
                    )
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = { }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = stringResource(
                        R.string.action_add_description
                    )
                )
            }
        }
    ) { innerPadding ->
        ProfileContent(
            modifier = Modifier.padding(innerPadding)
        )
    }
}


@Composable
fun ProfileContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {

                Image(
                    painter = painterResource(R.drawable.profile_picture),
                    contentDescription = "Käyttäjän profiilikuva",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter
                )

                Column(
                    modifier = Modifier.padding(20.dp)
                ) {

                    ProfileHeader(
                        name = "Jyri Nieminen",
                        role = "Tietotekniikan insinööriopiskelija",
                        description = "Opiskelen ICT-alaa ja olen kiinnostunut " +
                                "ohjelmoinnista, tietoverkoista ja web-kehityksestä."
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null
                        )
                        Text(
                            text = "${stringResource(R.string.label_location)}: Tampere"
                        )
                    }

                    InfoRow(
                        label = stringResource(R.string.label_specialization),
                        value = "Ohjelmistotekniikka"
                    )
                    InfoRow(
                        label = stringResource(R.string.label_interest),
                        value = "Tietoverkot"
                    )
                    InfoRow(
                        label = stringResource(R.string.label_hobby),
                        value = "Ohjelmointi"
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    ProfileActions()
                }
            }
        }
    }
}


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


@Composable
fun InfoRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
    ) {
        Text(
            text = "$label: ",
            style = MaterialTheme.typography.titleSmall
        )

        Text(
            text = value
        )
    }
}


@Composable
fun ProfileActions(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = { }
        ) {
            Text(
                text = stringResource(R.string.action_message)
            )
        }

        OutlinedButton(
            onClick = { }
        ) {
            Text(
                text = stringResource(R.string.action_follow)
            )
        }
    }
}


// Koko esittelynäkymän Preview
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    Harjoitus01Theme {
        ProfileScreen()
    }
}


// Pienemmän komponentin Preview erilaisella sisällöllä
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