package com.nilatilmoena.marvelapp.models.events


import com.google.gson.annotations.SerializedName

data class Characters(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)