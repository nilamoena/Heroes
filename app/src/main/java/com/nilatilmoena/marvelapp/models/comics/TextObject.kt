package com.nilatilmoena.marvelapp.models.comics


import com.google.gson.annotations.SerializedName

data class TextObject(
    val language: String,
    val text: String,
    val type: String
)