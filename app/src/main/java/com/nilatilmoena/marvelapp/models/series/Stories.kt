package com.nilatilmoena.marvelapp.models.series


import com.google.gson.annotations.SerializedName

data class Stories(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemXXX>,
    val returned: Int
)