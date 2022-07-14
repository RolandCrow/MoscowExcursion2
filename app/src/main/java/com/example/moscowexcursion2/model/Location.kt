package com.example.moscowexcursion2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Location(
    val lat: Double,
    val lon: Double,
) : Parcelable
