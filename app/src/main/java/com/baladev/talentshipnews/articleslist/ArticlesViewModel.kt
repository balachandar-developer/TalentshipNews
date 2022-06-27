package com.baladev.talentshipnews.articleslist

import androidx.lifecycle.MutableLiveData
import com.baladev.api.MyRepository
import com.baladev.api.RetrofitService
import com.baladev.model.Articles
import com.baladev.model.ArticlesList
import com.baladev.talentshipnews.base.viewmodel.BaseViewModel
import com.baladev.talentshipnews.provider.TempProvider
import com.baladev.talentshipnews.util.Loader
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticlesViewModel(val provider: TempProvider): BaseViewModel<ArticlesNavigation>() {
    val articlesList = MutableLiveData<List<Articles>>()

    val errorMessage = MutableLiveData<String>()

 /*   init {
        getAllArticles()
    }*/
    override suspend fun reloadData() {
        TODO("Not yet implemented")
    }

    val retrofitService = RetrofitService.getInstance()

    fun getAllArticles() {
        val response = MyRepository(retrofitService).getArticles()
        response.enqueue(object : Callback<ArticlesList> {
            override fun onResponse(call: Call<ArticlesList>, response: Response<ArticlesList>) {
                Loader.close()
                articlesList.postValue(response.body()?.articlesList)
            }

            override fun onFailure(call: Call<ArticlesList>, t: Throwable) {
                Loader.close()
                errorMessage.postValue(t.message)
            }

        })
    }

    fun goToNewsDetails(){
        //navigation.value = ArticlesNavigation.ToNewsDetails
    }
}