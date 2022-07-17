package com.example.moscowexcursion2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Routes(
    val title: String,
    val audio: String,
    val type: String,
    val points: List<Points>,
    val textContents: List<TextContents>,
    val media: List<Media>,
    val galleries: List<Galleries>,
): Parcelable
