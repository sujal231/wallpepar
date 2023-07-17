package com.example.wallpepar.api

import com.example.wallpepar.Model.wallpeparModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiInterface {


    @GET("search")

    fun getPhotos(
        @Header("Authorization")auth: String,
        @Query("query")query: String
    ) : Call<wallpeparModel>

}