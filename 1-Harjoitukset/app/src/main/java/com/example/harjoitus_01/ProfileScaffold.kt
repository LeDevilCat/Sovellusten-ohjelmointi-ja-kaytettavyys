package com.example.harjoitus_01

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.harjoitus_01.ui.theme.Harjoitus01Theme

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
                        name = "${stringResource(R.string.profile_name)}",
                        role = "${stringResource(R.string.profile_role)}",
                        description =
                            "${stringResource(R.string.profile_desc)}",
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
                        label = stringResource(
                            R.string.label_specialization
                        ),
                        value = stringResource(
                            R.string.specialisation
                        ),
                    )

                    InfoRow(
                        label = stringResource(
                            R.string.label_interest
                        ),
                        value = stringResource(
                            R.string.interest
                        ),
                    )

                    InfoRow(
                        label = stringResource(
                            R.string.label_hobby
                        ),
                        value = stringResource(
                            R.string.hobby
                        ),
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

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {
    Harjoitus01Theme {
        ProfileScreen()
    }
}