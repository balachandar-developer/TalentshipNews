package com.baladev.talentshipnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.baladev.api.MyRepository
import com.baladev.api.RetrofitService
import com.baladev.talentshipnews.databinding.ActivityArticlesBinding

class ArticlesActivity : AppCompatActivity() {
    private val TAG = "ArticlesActivity"
    private lateinit var binding: ActivityArticlesBinding

    lateinit var viewModel: ArticlesViewModel

    val retrofitService = RetrofitService.getInstance()

    val adapter = ArticlesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticlesBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //get viewmodel instance using MyViewModelFactory
        viewModel =
            ViewModelProvider(this, ArticlesViewModelFactory(MyRepository(retrofitService))).get(
                ArticlesViewModel::class.java
            )

        binding.recyclerview.adapter = adapter

        viewModel.articlesList.observe(this, Observer {
            Log.d("bala", it.toString())
            adapter.setArticlesList(it)

        })
        viewModel.errorMessage.observe(this, Observer {
            Log.d("bala", "errorMessage: $it")
        })

        viewModel.getAllArticles()

    }
}