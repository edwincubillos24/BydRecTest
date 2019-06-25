package com.edwinacubillos.bydrectest.results

import com.edwinacubillos.bydrectest.model.results.Results

interface ResultsContract {
    interface view {
        fun showResults(listResults: List<Results>?)
    }

    interface presenter {
        fun loadResults()
        fun resultsLoaded(listResults: List<Results>?)
    }

    interface interactor {
        fun loadResults()
        fun resultsLoaded(listResults: List<Results>?)
    }
}
