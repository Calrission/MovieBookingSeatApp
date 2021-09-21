package com.example.ticketscinema.models

data class ModelFilm(
    val title: String,
    val src_cover: String,
    val country: String,
    val category: String,
    val duration: String,
    val data_film: String,
    val version_D: String,
    val age: String,
    val rate_film: Float,
    val list_create_studio: List<String>,
    val listGroupSeats: List<ModelGroupSeats>
)

data class ModelGroupSeats(
    val listLineSeats: List<ModelLineSeats>
)

data class ModelLineSeats(
    val listSeats: List<ModelSeat>,
    val sim: String,
)

data class ModelSeat(
    var status: Int = 1
)