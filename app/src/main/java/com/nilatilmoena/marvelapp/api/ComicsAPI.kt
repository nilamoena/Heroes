package com.nilatilmoena.marvelapp.api

import com.nilatilmoena.marvelapp.models.comics.Comics
import retrofit2.Call
import retrofit2.http.GET

interface ComicsAPI {
    @GET("v1/public/comics?ts=1&apikey=235b763e9293189887741cb91a24f848&hash=109d8f917e46dbf3da65c4124883e0a8")
    fun getResponse(): Call<Comics>
}