package com.baladev.talentshipnews.articleslist

import com.baladev.model.NewsDetailsViewData

sealed class ArticlesNavigation{
    data class ToNewsDetails(val title: String, val date: String, val imageURL: String, val description: String): ArticlesNavigation()
}
