package com.example.moscowexcursion2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Points(
    val locations: Location,
    val ordering: Int,
): Parcelable
