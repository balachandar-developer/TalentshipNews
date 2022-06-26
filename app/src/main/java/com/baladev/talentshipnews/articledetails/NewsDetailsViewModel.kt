package com.baladev.talentshipnews.articledetails

import androidx.lifecycle.MutableLiveData
import com.baladev.model.NewsDetailsViewData
import com.baladev.talentshipnews.base.viewmodel.BaseViewModel
import com.baladev.talentshipnews.provider.TempProvider

class NewsDetailsViewModel(val provider: TempProvider): BaseViewModel<NewsDetailsNavigation>() {
    override suspend fun reloadData() {
        TODO("Not yet implemented")
    }
    val newsDetailsViewData = MutableLiveData(
        NewsDetailsViewData(
            provider.newsDetailsViewData.title,
            provider.newsDetailsViewData.date,
            provider.newsDetailsViewData.imageURL,
            provider.newsDetailsViewData.description
        ))





}