package com.example.moscowexcursion2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Media(
    val value: String,
    val ordering: Int,
    val type: String,
    val caption: String,
): Parcelable
