package com.nilatilmoena.marvelapp.api

import com.nilatilmoena.marvelapp.models.series.Series
import retrofit2.Call
import retrofit2.http.GET

interface SeriesAPI {
    @GET("https://gateway.marvel.com/v1/public/series?ts=1&apikey=235b763e9293189887741cb91a24f848&hash=109d8f917e46dbf3da65c4124883e0a8")
    fun getResponse(): Call<Series>
}