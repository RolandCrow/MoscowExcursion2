package com.example.moscowexcursion2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize



@Parcelize
data class Data(
    val id: Int,
    val title: String,
    val description: String? = null,
    val shortDescription: String? = null,
    val type: String,
    val img: String,
    val duration: Int,
    val authors: List<Authors>,
    val authorCompany: Authors,
    val routes: ArrayList<Routes>,



): Parcelable
