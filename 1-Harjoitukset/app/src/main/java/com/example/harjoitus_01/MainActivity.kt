package com.example.harjoitus_01

import android.os.Bundle
import androidx.compose.material3.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
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
            // aseta käyttöliittymän pääkomponentti
            // käyttöliittymö on Composable funktio
            // Composable on funktio, joka palauttaa käyttöliittymän
            MyGUI()
        }
    }
}
@Preview
@Composable
fun MyGUI(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF4E008E))
            .padding(20.dp)
            .wrapContentSize(Alignment.Center)
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Jyri Nieminen",
            fontSize = 40.sp,
            color = Color(0xFFFFDCA5),
            textAlign = TextAlign.Center,

        )
        Text(
            text = "Tietotekniikan insinööriopiskelija",
            color = Color(0xFFFFFFFF),
            textAlign = TextAlign.Center,

            )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        Text(
            text = "Suuntaudun Ohjelmistotekniikkaan sekä Tietoliikennetekniikkaan ja tietoverkkoihin.",
            color = Color(0xFFFFFFFF),
            textAlign = TextAlign.Center,

            )
        Spacer(
            modifier = Modifier.height(20.dp)
        )
        MyButton("nappi")
        }
}
@Composable
fun MyButton(buttonText: String){
    Button(
        onClick = { }
    ) {
        Text(buttonText)
    }
}
