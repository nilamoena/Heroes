package com.nilatilmoena.marvelapp.models.events


import com.google.gson.annotations.SerializedName

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXX>,
    val returned: Int
)