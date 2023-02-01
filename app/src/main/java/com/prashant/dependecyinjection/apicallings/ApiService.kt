package com.prashant.dependecyinjection.apicallings

import retrofit2.http.GET

interface ApiService {
    @GET("anything")
    suspend fun getFunctions(): List<String>
}