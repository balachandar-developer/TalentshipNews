package com.baladev.talentshipnews.articledetails

import android.os.Bundle
import android.view.View
import com.baladev.talentshipnews.R
import com.baladev.talentshipnews.BR
import com.baladev.talentshipnews.base.fragments.BaseFragment
import com.baladev.talentshipnews.databinding.FragmentArticlesListBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel
import android.util.Log
import com.baladev.talentshipnews.databinding.FragmentNewsDetailsBinding
import com.baladev.talentshipnews.util.Loader
import androidx.navigation.fragment.navArgs
import org.koin.core.parameter.parametersOf


class NewsDetailsFragment: BaseFragment<FragmentNewsDetailsBinding, NewsDetailsViewModel, NewsDetailsNavigation>() {

    override fun getLayoutRes(): Int  = R.layout.fragment_news_details

    override fun getModelId(): Int  = BR.viewModel

    override fun createViewModel(): NewsDetailsViewModel = getViewModel()


    override fun navigate(navigation: NewsDetailsNavigation) {
        TODO("Not yet implemented")
    }


}