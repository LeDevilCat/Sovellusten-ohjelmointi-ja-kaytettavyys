package com.example.harjoitus_01.ui.website

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.harjoitus_01.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebsiteScreen(
    onBackClick: (() -> Unit)? = null,
) {

    val context = LocalContext.current

    val websiteName = stringResource(R.string.website_name)
    val url = stringResource(R.string.website_url)
    val location = stringResource(R.string.website_address)

    val browserNotFoundError = stringResource(R.string.error_browser_not_found)
    val mapNotFoundError = stringResource(R.string.error_map_not_found)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = websiteName)
                },
                navigationIcon = {
                    onBackClick?.let { onClick ->
                        IconButton(onClick = onClick) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = stringResource(R.string.action_back)
                            )
                        }
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                onClick = {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(url)
                    )

                    try {
                        context.startActivity(intent)
                    } catch (_: ActivityNotFoundException) {
                        Toast.makeText(
                            context,
                            browserNotFoundError,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            ) {
                Text(
                    text = stringResource(R.string.action_open_website)
                )
            }

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Text(
                text = location
            )

            Spacer(
                modifier = Modifier.height(8.dp)
            )

            Button(
                onClick = {
                    val mapUri = Uri.parse(
                        "geo:0,0?q=" + Uri.encode(location)
                    )

                    val mapIntent = Intent(
                        Intent.ACTION_VIEW,
                        mapUri
                    )

                    try {
                        context.startActivity(mapIntent)
                    } catch (_: ActivityNotFoundException) {
                        Toast.makeText(
                            context,
                            mapNotFoundError,
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            ) {
                Text(
                    text = stringResource(R.string.action_show_map)
                )
            }
        }
    }
}
