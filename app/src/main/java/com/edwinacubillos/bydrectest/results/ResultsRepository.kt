package com.edwinacubillos.bydrectest.results

import com.edwinacubillos.bydrectest.model.results.Results
import com.edwinacubillos.bydrectest.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResultsRepository : IResultsRepository {

    private var interactor: ResultsContract.interactor

    constructor(interactor: ResultsContract.interactor) {
        this.interactor = interactor
    }

    override fun loadResults() {
        ApiService.create()
            .getResultsMatches()
            .enqueue(object : Callback<List<Results>> {
                override fun onFailure(call: Call<List<Results>>, t: Throwable) {

                }

                override fun onResponse(call: Call<List<Results>>, response: Response<List<Results>>) {
                    if (response.isSuccessful) {
                        interactor.resultsLoaded(response.body())
                    }
                }
            })
    }
}
