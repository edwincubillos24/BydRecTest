package com.edwinacubillos.bydrectest.results

import com.edwinacubillos.bydrectest.model.results.Results

class ResultsPresenter : ResultsContract.presenter {

    private var view: ResultsContract.view
    private var interactor: ResultsContract.interactor

    constructor(view: ResultsContract.view) {
        this.view = view
        interactor = ResultsInteractor(this)
    }

    override fun loadResults() {
        interactor.loadResults()
    }

    override fun resultsLoaded(listResults: List<Results>?) {
        view.showResults(
            listResults
        )
    }
}
