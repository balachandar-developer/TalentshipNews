package com.baladev.talentshipnews.articledetails

import com.baladev.talentshipnews.R
import com.baladev.talentshipnews.BR
import com.baladev.talentshipnews.base.fragments.BaseFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel
import com.baladev.talentshipnews.databinding.FragmentNewsDetailsBinding


class NewsDetailsFragment: BaseFragment<FragmentNewsDetailsBinding, NewsDetailsViewModel, NewsDetailsNavigation>() {

    override fun getLayoutRes(): Int  = R.layout.fragment_news_details

    override fun getModelId(): Int  = BR.viewModel

    override fun createViewModel(): NewsDetailsViewModel = getViewModel()


    override fun navigate(navigation: NewsDetailsNavigation) {
        TODO("Not yet implemented")
    }


}