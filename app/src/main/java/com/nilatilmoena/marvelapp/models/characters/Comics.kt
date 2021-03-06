package com.nilatilmoena.marvelapp.models.characters


import com.google.gson.annotations.SerializedName

data class Comics(
    val available: Int,
    val collectionURI: String,
    val items: List<Item>,
    val returned: Int
)