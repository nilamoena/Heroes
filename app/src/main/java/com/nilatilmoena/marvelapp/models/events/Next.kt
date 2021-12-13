package com.nilatilmoena.marvelapp.models.events


import com.google.gson.annotations.SerializedName

data class Next(
    val name: String,
    val resourceURI: String
)