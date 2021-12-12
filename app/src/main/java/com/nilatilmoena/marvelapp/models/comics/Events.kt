package com.nilatilmoena.marvelapp.models.comics


import com.google.gson.annotations.SerializedName

data class Events(
    val available: Int,
    val collectionURI: String,
    val items: List<Any>,
    val returned: Int
)