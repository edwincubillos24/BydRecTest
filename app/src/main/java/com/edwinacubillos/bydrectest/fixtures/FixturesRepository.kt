package com.edwinacubillos.bydrectest.fixtures

import com.edwinacubillos.bydrectest.model.fixtures.Fixtures
import com.edwinacubillos.bydrectest.services.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FixturesRepository : IFixturesRepository {

    private var interactor: FixturesContract.Interactor

    constructor(interactor: FixturesContract.Interactor) {
        this.interactor = interactor
    }

    override fun loadFixtures() {
        ApiService.create()
            .getFixturesMatches()
            .enqueue(object : Callback<List<Fixtures>> {
                override fun onFailure(call: Call<List<Fixtures>>, t: Throwable) {
                }

                override fun onResponse(call: Call<List<Fixtures>>, response: Response<List<Fixtures>>) {
                    if (response.isSuccessful) {
                        interactor.fixturesLoaded(response.body())
                    }
                }
            })
    }
}
