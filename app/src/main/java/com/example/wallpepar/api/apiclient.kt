package com.example.wallpepar.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class apiclient {

    companion object {
        var baseurl = "https://api.pexels.com/v1/"
        var retrofit: Retrofit? = null

        fun getclient(): Retrofit {

            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            }
            return retrofit!!
        }
    }

}