package com.lalitp.zomatoapp.utils

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lalitp.zomatoapp.R
import com.lalitp.zomatoapp.utils.extension.getParentActivity
import com.lalitp.zomatoapp.view.widget.EndlessRecyclerViewScrollListener


@BindingAdapter("mutableAdapter")
fun setAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<*>) {
    view.adapter = adapter
}

@BindingAdapter("mutableScrollListener")
fun setScrollListener(view: RecyclerView, scrollListener: RecyclerView.OnScrollListener){
    view.addOnScrollListener(scrollListener)
}

@BindingAdapter("mutableVisibility")
fun setMutableVisibility(view: View, visibility: MutableLiveData<Int>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && visibility != null) {
        visibility.observe(
            parentActivity,
            Observer { value -> view.visibility = value ?: View.VISIBLE })
    }
}

@BindingAdapter("mutableText")
fun setMutableText(view: TextView, text: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && text != null) {
        text.observe(parentActivity, Observer { value -> view.text = value ?: "" })
    }
}

@BindingAdapter("mutableSrc")
fun loadImage(view: ImageView, url: MutableLiveData<String>?) {
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && url != null) {

        url.observe(parentActivity, Observer { value ->
            Glide.with(view.getContext())
                .load(value).apply(getRequestOption())
                .error(R.drawable.zomatologo)
                .into(
                    view
                )
        })


    }
}

fun getRequestOption() : RequestOptions{
    return RequestOptions.overrideOf(500)
}

@BindingAdapter("mutableRating")
fun loadRating(view: RatingBar, rating : MutableLiveData<String>?){
    val parentActivity: AppCompatActivity? = view.getParentActivity()
    if (parentActivity != null && rating != null) {
        rating.observe(parentActivity, Observer { value -> view.rating = value.toFloat() ?: 0f })
    }
}
