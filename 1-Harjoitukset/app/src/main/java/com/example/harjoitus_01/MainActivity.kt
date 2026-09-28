package com.example.harjoitus_01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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
                TechnologyListScreen()
            }
        }
    }
}