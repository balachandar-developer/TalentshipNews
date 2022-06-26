package com.baladev.talentshipnews.articleslist

import com.baladev.talentshipnews.BR
import com.baladev.talentshipnews.R
import com.baladev.talentshipnews.base.activity.BaseViewModelActivity
import com.baladev.talentshipnews.databinding.ActivityArticlesBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel


class ArticlesActivity : BaseViewModelActivity<ActivityArticlesBinding, ArticlesViewModel>() {
    override fun getLayoutRes(): Int  = R.layout.activity_articles

    override fun getModelId(): Int  = BR.viewModel

    override fun createViewModel(): ArticlesViewModel = getViewModel()
}