package com.example.moscowexcursion2.model



data class Data(
    val id: Int,
    val title: String,
    val description: String,
    val shortDescription: String?,
    val type: String,
    val img: String,
    val duration: Int,
    val authors: List<Authors>,
    val authorCompany: List<Authors>,
    val routes: List<Routes>?,



)
