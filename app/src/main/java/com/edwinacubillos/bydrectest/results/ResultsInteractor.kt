package com.edwinacubillos.bydrectest.results

import com.edwinacubillos.bydrectest.model.results.Results

class ResultsInteractor : ResultsContract.interactor {

    private var presenter: ResultsContract.presenter
    private var repository: IResultsRepository

    constructor(presenter: ResultsContract.presenter) {
        this.presenter = presenter
        repository = ResultsRepository(this)
    }

    override fun loadResults() {
        repository.loadResults()
    }

    override fun resultsLoaded(listResults: List<Results>?) {
        presenter.resultsLoaded(listResults)
    }
}
