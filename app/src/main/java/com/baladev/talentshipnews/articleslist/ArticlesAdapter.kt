package com.baladev.talentshipnews.articleslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.baladev.model.Articles
import com.baladev.talentshipnews.R
import com.baladev.talentshipnews.databinding.LayoutArticlesItemBinding
import com.bumptech.glide.Glide

class ArticlesAdapter(val NewsClickListener: NewsClickListener): RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder>() {

    var articles = mutableListOf<Articles>()

    fun setArticlesList(articles: List<Articles>){
        this.articles = articles.toMutableList()
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        val binding = LayoutArticlesItemBinding.inflate(inflater, parent, false)
        return ArticlesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticlesViewHolder, position: Int) {
        holder.bindView(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    inner  class ArticlesViewHolder(val binding: LayoutArticlesItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bindView(item: Articles){
            with(itemView){
                binding.tvTitle.text = item.title ?: "-"
                binding.tvDate.text = item.publishedAt ?: "-"
                binding.tvShortDescription.text = item.description
                Glide.with(this)
                    .load(item.urlToImage)
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(binding.imgViewNews)

                binding.root.setOnClickListener {
                    NewsClickListener.onNewsTapped(item)
                }
            }
        }
    }
}

interface NewsClickListener {
    fun onNewsTapped(data: Articles)
}