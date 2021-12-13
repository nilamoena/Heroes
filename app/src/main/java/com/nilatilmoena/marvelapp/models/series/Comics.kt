package com.nilatilmoena.marvelapp.models.series


import com.google.gson.annotations.SerializedName

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)