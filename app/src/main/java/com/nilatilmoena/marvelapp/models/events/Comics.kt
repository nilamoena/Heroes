package com.nilatilmoena.marvelapp.models.events


import com.google.gson.annotations.SerializedName

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)