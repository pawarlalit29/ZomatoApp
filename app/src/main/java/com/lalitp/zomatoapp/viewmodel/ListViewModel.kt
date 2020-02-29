package com.lalitp.zomatoapp.viewmodel

import android.location.Location
import android.util.Log
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.lalitp.zomatoapp.base.BaseViewModel
import com.lalitp.zomatoapp.model.Restaurant
import com.lalitp.zomatoapp.model.RestaurantData
import com.lalitp.zomatoapp.network.ApiService
import com.lalitp.zomatoapp.utils.FROM_LOADMORE
import com.lalitp.zomatoapp.utils.FROM_REFRESH
import com.lalitp.zomatoapp.utils.FROM_START
import com.lalitp.zomatoapp.view.adapter.RestaurantListAdapter
import com.lalitp.zomatoapp.view.widget.EndlessRecyclerViewScrollListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListViewModel : BaseViewModel() {
    // TODO: Implement the ViewModel
    @Inject
    lateinit var apiService: ApiService

    val listAdapter: RestaurantListAdapter = RestaurantListAdapter()

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val recyclerViewVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<String> = MutableLiveData()

    val errorClickListener = View.OnClickListener { loadRestaurant(FROM_START) }
    val staggeredGridLayoutManager = StaggeredGridLayoutManager(2, 1)

    val isSwipeLoading = MutableLiveData<Boolean>()

    var parameterMap = HashMap<String, String>()
    val count = MutableLiveData<Int>();
    val start = MutableLiveData<Int>();

    private lateinit var subscription: Disposable

    fun fetchRestaurant(location: Location) {
        count.value = 15;
        start.value = 0;

        parameterMap["lon"] = location.longitude.toString()
        parameterMap["lat"] = location.latitude.toString()
        parameterMap["radius"] = "5000" // near by 5KM
        parameterMap["count"] = count.value.toString()
        parameterMap["start"] = start.value.toString()

        loadRestaurant(FROM_START)
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    fun onSwipeRefresh() {
        start.value = 0
        isSwipeLoading.value = true
        loadRestaurant(FROM_REFRESH)
    }

    private fun loadRestaurant(from: String) {

        subscription = apiService.getRestaurant(parameterMap)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrievePostListStart(from) }
            .doOnTerminate { onRetrievePostListFinish() }
            .subscribe(
                { result -> onRetrievePostListSuccess(from, result) },
                { error -> onRetrievePostListError(error) }
            )

    }

    private fun onRetrievePostListStart(from: String) {
        if (from == FROM_START) {
            loadingVisibility.value = View.VISIBLE
            recyclerViewVisibility.value = View.GONE
        }

        errorMessage.value = null
    }

    private fun onRetrievePostListFinish() {
        loadingVisibility.value = View.GONE
        recyclerViewVisibility.value = View.VISIBLE
        isSwipeLoading.value = false
    }

    private fun onRetrievePostListSuccess(from: String, restaurantData: RestaurantData) {
        isSwipeLoading.value = false

        var listItem: List<Restaurant>? = restaurantData.restaurants as List<Restaurant>?

        if (from == FROM_START && from == FROM_REFRESH)
            listAdapter.addRestaurantList(listItem!!)
        else {
            listAdapter.updateRestaurantList(listItem!!)
        }
    }

    private fun onRetrievePostListError(throwable: Throwable) {
        isSwipeLoading.value = false
        Log.v("onRetrievePostListError", throwable.message)
        errorMessage.value = throwable.message
    }

    fun onScrollListener(): EndlessRecyclerViewScrollListener {
        return object : EndlessRecyclerViewScrollListener(staggeredGridLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int) {
                start.value = totalItemsCount + start.value!!
                loadRestaurant(FROM_LOADMORE)
            }
        }
    }

    fun onPasswordTextChanged(
        s: CharSequence, start: Int, before: Int,
        count: Int
    ) {
        parameterMap["q"] = s.toString()
        loadRestaurant(FROM_START)
    }
}
