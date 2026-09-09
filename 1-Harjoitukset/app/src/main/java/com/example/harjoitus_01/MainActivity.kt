package com.example.harjoitus_01

import android.os.Bundle
import androidx.compose.material3.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.harjoitus_01.ui.theme.Harjoitus01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Harjoitus01Theme() {
            // aseta käyttöliittymän pääkomponentti
            // käyttöliittymö on Composable funktio
            // Composable on funktio, joka palauttaa käyttöliittymän
            MyGUI()
                }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyGUI() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Card(
            modifier = Modifier.fillMaxWidth()
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                // Otsikko
                Text(
                    text = "Jyri Nieminen",
                    style = MaterialTheme.typography.headlineMedium
                )

                // Rooli
                Text(
                    text = "Tietotekniikan insinööriopiskelija",
                    style = MaterialTheme.typography.titleMedium
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                // Lyhyt kuvaus
                Text(
                    text = "Opiskelen ICT-alaa ja olen kiinnostunut " +
                            "ohjelmoinnista, tietoverkoista ja web-kehityksestä.",
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                // Tieto 1
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Text(
                        text = "Suuntautuminen: ",
                        style = MaterialTheme.typography.titleSmall
                    )

                    Text(
                        text = "Ohjelmistotekniikka"
                    )
                }

                // Tieto 2
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Text(
                        text = "Kiinnostuksen kohde: ",
                        style = MaterialTheme.typography.titleSmall
                    )

                    Text(
                        text = "Tietoverkot"
                    )
                }

                // Tieto 3
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Text(
                        text = "Harrastus: ",
                        style = MaterialTheme.typography.titleSmall
                    )

                    Text(
                        text = "Ohjelmointi"
                    )
                }

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                // Painikkeet
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    Button(
                        onClick = { }
                    ) {
                        Text("Ota yhteyttä")
                    }

                    OutlinedButton(
                        onClick = { }
                    ) {
                        Text("Seuraa")
                    }
                }
            }
        }
    }
}