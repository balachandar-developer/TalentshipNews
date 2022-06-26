package com.baladev.talentshipnews.di

import com.baladev.talentshipnews.articledetails.NewsDetailsViewModel
import com.baladev.talentshipnews.articleslist.ArticlesViewModel
import com.baladev.talentshipnews.provider.TempProvider
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import org.koin.dsl.single

object KoinModules {

    private val module = module {
        viewModel<ArticlesViewModel>()
        viewModel<NewsDetailsViewModel>()
        single<TempProvider>()

    }

    val appModules = listOf(module)
}