package com.baladev.talentshipnews.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide


suspend fun MutableLiveData<Boolean>.withLoading(
    work: suspend () -> Unit
) {
    postValue(true)
    work()
    postValue(false)
}

inline fun <T> Fragment.observeLiveData(liveData: LiveData<T>, crossinline observer: (T) -> Unit) {
    liveData.observe(viewLifecycleOwner) { observer(it) }
}

fun Fragment.navigateTo(direction: NavDirections) {
    findNavController().navigate(direction)
}

@BindingAdapter("profileImage")
fun loadImage(view: ImageView, imageUrl: String?) {
    Glide.with(view.getContext())
        .load(imageUrl)
        .into(view)
}
