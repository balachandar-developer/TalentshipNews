package com.baladev.talentshipnews

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.baladev.api.MyRepository
import com.baladev.model.Articles
import com.baladev.model.ArticlesList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticlesViewModel(private val repository: MyRepository): ViewModel() {
    val articlesList = MutableLiveData<List<Articles>>()

    val errorMessage = MutableLiveData<String>()

    fun getAllArticles(){
        val response = repository.getArticles()

        response.enqueue(object : Callback<ArticlesList> {
            override fun onResponse(call: Call<ArticlesList>, response: Response<ArticlesList>) {
                articlesList.postValue(response.body()?.articlesList)
            }

            override fun onFailure(call: Call<ArticlesList>, t: Throwable) {
                errorMessage.postValue(t.message)
            }

        })
    }
}