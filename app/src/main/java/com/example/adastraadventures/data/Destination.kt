package com.example.adastraadventures.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.adastraadventures.R

data class Destination(
    @StringRes val destinationName: Int,
    @DrawableRes val destinationImage: Int
)

val destinations: List<Destination> = listOf(
    Destination(R.string.moon, R.drawable.moon_image),
    Destination(R.string.mars, R.drawable.mars_image),
    Destination(R.string.asteroid, R.drawable.asteroid_image),
    Destination(R.string.enceladus, R.drawable.enceladus_image),
    Destination(R.string.venus, R.drawable.venus_image)
)