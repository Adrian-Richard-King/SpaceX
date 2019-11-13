package com.example.spacex.viewmodel.spacexlist

import android.annotation.SuppressLint
import android.content.Context
import androidx.annotation.VisibleForTesting
import com.example.spacex.model.SpaceXModel
import com.example.spacex.network.ApiClient
import com.example.spacex.util.RxSingleSchedulers
import com.example.spacex.util.Utils
import com.example.spacex.viewmodel.CustomViewModel
import com.example.spacex.viewmodel.spacexlist.adapters.SpaceAdapter
import io.reactivex.disposables.CompositeDisposable
import java.util.*

class SpaceXViewModel(var context: Context) : CustomViewModel() {

    private var disposable: CompositeDisposable? = CompositeDisposable()
    val data: ArrayList<SpaceXModel> = ArrayList()
    private var rxSingleSchedulers: RxSingleSchedulers = RxSingleSchedulers.DEFAULT
    private var pageOffset = 0
    private var apiService: ApiClient = ApiClient()
    val adapter: SpaceAdapter = SpaceAdapter(context, data)

    @VisibleForTesting
    constructor(
        apiClient: ApiClient,
        rxSingleSchedulers: RxSingleSchedulers,
        context: Context
    ) : this(context) {
        this.apiService = apiClient
        this.rxSingleSchedulers = rxSingleSchedulers
    }

    fun loadNextData() {
        pageOffset += 10
        loadData()
    }

    @SuppressLint("CheckResult")
    fun loadData() {
        onLoading()
        disposable?.add(
            apiService.getSpaceXList(pageLimit, pageOffset)
                .compose(rxSingleSchedulers.applySchedulers())
                .subscribe(this::onSuccess, this::onError)
        )
    }

    private fun onSuccess(spaceXModels: List<SpaceXModel>) {
        data.addAll(spaceXModels)
        adapter.notifyDataSetChanged()
        dataLoading.value = false
    }

    private fun onError(error: Throwable) {
        errorMessage = error.message ?: ""
        dataLoading.value = false
    }

    private fun onLoading() {
        dataLoading.value = true
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.run {
            clear()
            null
        }
    }

    companion object {
        private const val pageLimit = 10
    }
}
