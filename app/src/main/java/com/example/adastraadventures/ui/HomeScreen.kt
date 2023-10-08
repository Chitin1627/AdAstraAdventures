package com.example.adastraadventures.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.adastraadventures.R


enum class ScreenName(@StringRes val title: Int) {
    Start(title = R.string.app_name),
    Destinations(title = R.string.top_destinations),
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceApp(
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentScreen = ScreenName.valueOf(backStackEntry?.destination?.route ?: ScreenName.Start.name)

    Scaffold(
        topBar = { AppTopBar(title = stringResource(id = currentScreen.title)) }
    ) {innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ScreenName.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = ScreenName.Start.name) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(innerPadding),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    HomeScreenCard(
                        title = R.string.top_destinations,
                        image = R.drawable.rocket,
                        onClick = {navController.navigate(ScreenName.Destinations.name)})
                }
            }

            composable(route = ScreenName.Destinations.name) {
                AppDestinationScreen(
                    contentPadding = innerPadding,
                    onClick = {}
                )
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenCard(
    @StringRes title: Int,
    @DrawableRes image: Int,
    onClick: ()->Unit,
    modifier : Modifier = Modifier
) {
    Card(
        shape = RoundedCornerShape(32.dp),
        modifier = modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 50.dp,
                bottom = 50.dp),
        colors = CardDefaults
            .cardColors(
                containerColor = MaterialTheme
                    .colorScheme
                    .onTertiary),
        elevation = CardDefaults.cardElevation(8.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.onTertiaryContainer),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(4.dp))

            Image(
                painter = painterResource(image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(400.dp)
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 16.dp
                    )
                    .align(Alignment.CenterHorizontally)
                    .clip(RoundedCornerShape(16.dp))

            )

            Spacer(modifier = Modifier.padding(4.dp))

            Text(
                text = stringResource(id = title),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.ExtraBold,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String
) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.ExtraBold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    textAlign = TextAlign.Center
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.onTertiary
        )
    )
}

@Preview(showSystemUi = true)
@Composable
fun CardPreview() {
    SpaceApp()
}
