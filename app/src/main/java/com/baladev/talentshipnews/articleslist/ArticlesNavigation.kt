package com.baladev.talentshipnews.articleslist


sealed class ArticlesNavigation{
    data class ToNewsDetails(val title: String, val date: String, val imageURL: String, val description: String): ArticlesNavigation()
}
