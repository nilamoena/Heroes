package com.nilatilmoena.marvelapp.models.characters


import com.google.gson.annotations.SerializedName

data class Characters(
    val attributionHTML: String,
    val attributionText: String,
    val code: Int,
    val copyright: String,
    val `data`: Data,
    val etag: String,
    val status: String
)