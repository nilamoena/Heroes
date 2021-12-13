package com.nilatilmoena.marvelapp.api

import com.nilatilmoena.marvelapp.models.events.Events
import retrofit2.Call
import retrofit2.http.GET

interface EventsAPI {
    @GET("https://gateway.marvel.com/v1/public/events?ts=1&apikey=235b763e9293189887741cb91a24f848&hash=109d8f917e46dbf3da65c4124883e0a8")
    fun getResponse(): Call<Events>
}