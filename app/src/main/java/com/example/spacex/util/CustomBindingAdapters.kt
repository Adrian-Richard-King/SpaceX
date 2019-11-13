package com.example.spacex.util

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView

object CustomBindingAdapters {

    @JvmStatic
    @BindingAdapter("app:adapter", "app:data")
    fun <T : CustomRecyclerViewAdapter<*, *>> bind(
        recyclerView: RecyclerView,
        adapter: T,
        data: List<Nothing>
    ) {
        recyclerView.adapter = adapter
        adapter.updateData(data)
    }

    @JvmStatic
    @BindingAdapter("app:adapter", "app:data")
    fun <T : CustomRecyclerViewAdapter<*, *>> bind(
        recyclerView: RecyclerView,
        adapter: T,
        data: MutableLiveData<List<Nothing>>
    ) {
        recyclerView.adapter = adapter
        adapter.updateData(data.value!!)
    }
}