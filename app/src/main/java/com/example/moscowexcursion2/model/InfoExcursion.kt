package com.example.moscowexcursion2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class InfoExcursion(
    val success: Boolean,
    val data: List<Data>
): Parcelable
