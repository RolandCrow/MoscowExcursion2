package com.example.moscowexcursion2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Galleries(
    val value: List<String>,
    val ordering: Int,
    val type: String,
    val captions: String? = null

): Parcelable
