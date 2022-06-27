package com.baladev.talentshipnews.articleslist

import android.os.Bundle
import android.view.View
import com.baladev.talentshipnews.R
import com.baladev.talentshipnews.BR
import com.baladev.talentshipnews.base.fragments.BaseFragment
import com.baladev.talentshipnews.databinding.FragmentArticlesListBinding
import org.koin.androidx.viewmodel.ext.android.getViewModel
import android.util.Log
import android.widget.Toast
import androidx.navigation.Navigation
import com.baladev.model.Articles
import com.baladev.model.NewsDetailsViewData
import com.baladev.talentshipnews.util.Loader
import com.baladev.talentshipnews.util.navigateTo
import com.baladev.talentshipnews.util.observeLiveData


class ArticlesListFragment: BaseFragment<FragmentArticlesListBinding, ArticlesViewModel,
        ArticlesNavigation>(), NewsClickListener {
    override fun getLayoutRes(): Int  = R.layout.fragment_articles_list

    override fun getModelId(): Int  = BR.viewModel

    override fun createViewModel(): ArticlesViewModel = getViewModel()

    override fun navigate(navigation: ArticlesNavigation) {
        when(navigation){
            is ArticlesNavigation.ToNewsDetails -> {
               /* navigateTo(ArticlesListFragmentDirections.actionListToDetails(
                    navigation.title,
                    navigation.date,
                    navigation.imageURL,
                    navigation.description))*/
            }
        }
    }


    val adapter = ArticlesAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerview.adapter = adapter
        Loader.show(context)
        viewModel.getAllArticles()
        observeLiveData(viewModel.articlesList){
            adapter.setArticlesList(it)
        }

        observeLiveData(viewModel.errorMessage){
            Toast.makeText(context, "Error on retrieving data: $it", Toast.LENGTH_SHORT).show()
        }

    }



    override fun onNewsTapped(data: Articles) {
       // viewModel.goToNewsDetails()

       /* navigateTo(ArticlesListFragmentDirections.actionListToDetails(
            data.title,
        data.publishedAt,
        data.urlToImage,
        data.description))*/

        navigateTo(ArticlesListFragmentDirections.actionListToDetails())
        viewModel.provider.newsDetailsViewData = NewsDetailsViewData(
            data.title ?: "Not available",
            data.publishedAt ?: "Not available",
            data.urlToImage?: "",
            data.content ?: "Not available"
        )

    }


}