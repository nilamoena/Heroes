package com.nilatilmoena.marvelapp.models.events


import com.google.gson.annotations.SerializedName

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXXX>,
    val returned: Int
)