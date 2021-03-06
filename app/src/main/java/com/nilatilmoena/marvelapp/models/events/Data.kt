package com.nilatilmoena.marvelapp.models.events


import com.google.gson.annotations.SerializedName

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: List<Result>,
    val total: Int
)