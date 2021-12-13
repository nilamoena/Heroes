package com.nilatilmoena.marvelapp.models.events


import com.google.gson.annotations.SerializedName

data class Series(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: Int
)