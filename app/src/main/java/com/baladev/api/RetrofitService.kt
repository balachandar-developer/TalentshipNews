package com.baladev.api

import com.baladev.model.ArticlesList
import com.chuckerteam.chucker.api.ChuckerInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("v2/top-headlines?country=us&category=business&apikey=f2af2b76847a4b6f9944ad5da5d55b86")
    fun getAllArticles(): Call<ArticlesList>

    companion object {

        var retrofitService: RetrofitService? = null

        //Create the Retrofit service instance using the retrofit.
        fun getInstance(): RetrofitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://newsapi.org/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}