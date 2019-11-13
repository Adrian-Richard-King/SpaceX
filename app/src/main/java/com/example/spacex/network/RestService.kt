package com.example.spacex.network

import com.example.spacex.model.SpaceXModel

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RestService {
    @GET(Constants.URL_SPACE_DATA)
    fun getSpaceXData(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("sort") sortBy: String,
        @Query("order") order: String
    ): Single<List<SpaceXModel>>
}