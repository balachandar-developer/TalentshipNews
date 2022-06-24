package com.baladev.api

class MyRepository(private val retrofitService: RetrofitService) {
    fun getArticles() = retrofitService.getAllArticles()
}