package com.baladev.talentshipnews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.baladev.api.MyRepository

class ArticlesViewModelFactory(private val myRepository: MyRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ArticlesViewModel::class.java)) {
            ArticlesViewModel(this.myRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}