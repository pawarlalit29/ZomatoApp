package com.lalitp.zomatoapp.viewmodel

import androidx.lifecycle.MutableLiveData
import com.lalitp.zomatoapp.base.BaseViewModel
import com.lalitp.zomatoapp.model.Restaurant

class ListItemViewModel : BaseViewModel(){
    private val title = MutableLiveData<String>()
    private val rating = MutableLiveData<String>()
    private var thumb = MutableLiveData<String>()
    private var review = MutableLiveData<String>()
    private var description = MutableLiveData<String>()

    fun bind(restaurant: Restaurant){
        title.value = restaurant.restaurant?.name
        thumb.value = restaurant.restaurant?.thumb
        rating.value = restaurant.restaurant?.userRating?.aggregateRating
        review.value = "${restaurant.restaurant?.userRating?.votes} Reviews"
        description.value = getFullDesciption(restaurant)

    }

    fun getTitle() :MutableLiveData<String>{
        return title
    }

    fun getDescription() : MutableLiveData<String>{
        return description
    }

    fun getReviews() : MutableLiveData<String>{
        return review
    }

    fun getRating() : MutableLiveData<String> {
        return rating
    }

    fun getThumb() : MutableLiveData<String>{
        return thumb
    }
    private fun getFullDesciption(restaurant: Restaurant) : String {
        return "${restaurant.restaurant?.currency} ${restaurant.restaurant?.averageCostForTwo} for two."
    }
}