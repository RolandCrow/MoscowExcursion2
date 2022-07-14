package com.example.moscowexcursion2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Authors(
    val title: String,
    val description: String,
    val img: String,
): Parcelable

