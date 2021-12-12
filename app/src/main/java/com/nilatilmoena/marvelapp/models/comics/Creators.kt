package com.nilatilmoena.marvelapp.models.comics


import com.google.gson.annotations.SerializedName

data class Creators(
    val available: Int,
    val collectionURI: String,
    val items: List<ItemX>,
    val returned: Int
)