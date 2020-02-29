package com.lalitp.zomatoapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.lalitp.zomatoapp.R
import com.lalitp.zomatoapp.databinding.CustomRestaurantListBinding
import com.lalitp.zomatoapp.model.Restaurant
import com.lalitp.zomatoapp.viewmodel.ListItemViewModel


class RestaurantListAdapter : RecyclerView.Adapter<RestaurantListAdapter.ViewHolder>() {
    private var postDataList = ArrayList<Restaurant>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RestaurantListAdapter.ViewHolder {
        val binding: CustomRestaurantListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.custom_restaurant_list,
            parent,
            false
        )
        binding.viewModel = ListItemViewModel()
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return postDataList.size
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(postDataList[position])
    }

    fun updateRestaurantList(postList: List<Restaurant>) {
        if (!postDataList.isEmpty())
            postDataList.clear()

        postDataList.addAll(postList)
        notifyDataSetChanged()
    }

    fun addRestaurantList(postList: List<Restaurant>) {
        postDataList.addAll(postList)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: CustomRestaurantListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(restaurant: Restaurant) {
            binding.viewModel?.bind(restaurant)
        }

    }

}