package com.example.adastraadventures.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.adastraadventures.data.Destination
import com.example.adastraadventures.data.destinations


@Composable
fun AppDestinationScreen(
    contentPadding: PaddingValues,
    onClick: ()->Unit) {
    LazyColumn(contentPadding = contentPadding) {
        items(destinations){
            DestinationCard(
                destination = it,
                onClick = onClick
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DestinationCard(
    destination: Destination,
    onClick: ()->Unit,
    modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = 8.dp,
                bottom = 8.dp,
                start = 16.dp,
                end = 16.dp
            ),
        colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer),
        onClick = onClick
    ) {
        Row(
            modifier = modifier
                .sizeIn(minHeight = 60.dp)
        ) {
            Image(
                painter = painterResource(id = destination.destinationImage),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 12.dp)
                    .clip(CircleShape)
                    .size(45.dp)
            )

            Text(
                text = stringResource(id = destination.destinationName),
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(start = 12.dp)
            )
        }
    }
}

@Preview
@Composable
fun DestinationPreview() {
    AppDestinationScreen(PaddingValues(10.dp), {})
}