package com.example.harjoitus_01

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun WebsiteScreen() {

    val context = LocalContext.current

    val websiteName = "TAMK"
    val url = "https://www.tuni.fi/tamk"
    val location = "Kuntokatu 3, 33520 Tampere"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = websiteName
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = url
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Button(
            onClick = {

                val intent = Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse(url)
                )

                try {
                    context.startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(
                        context,
                        "Sopivaa selainta ei löytynyt.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        ) {
            Text("Avaa verkkosivu")
        }

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Button(
            onClick = {

                val locationUri =
                    Uri.parse("geo:0,0?q=${Uri.encode(location)}")

                val intent = Intent(
                    Intent.ACTION_VIEW,
                    locationUri
                )

                try {
                    context.startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    Toast.makeText(
                        context,
                        "Sopivaa karttasovellusta ei löytynyt.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        ) {
            Text("Näytä kartalla")
        }
    }
}