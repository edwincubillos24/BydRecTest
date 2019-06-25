package com.edwinacubillos.bydrectest.services

import com.edwinacubillos.bydrectest.model.fixtures.Fixtures
import com.edwinacubillos.bydrectest.model.results.Results
import com.edwinacubillos.bydrectest.utils.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("fixtures.json")
    fun getFixturesMatches(): Call<List<Fixtures>>

    @GET("results.json")
    fun getResultsMatches(): Call<List<Results>>

    companion object {
        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}
