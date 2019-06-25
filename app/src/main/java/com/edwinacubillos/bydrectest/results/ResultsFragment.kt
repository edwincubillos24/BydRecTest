package com.edwinacubillos.bydrectest.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.bydrectest.BydRecTest
import com.edwinacubillos.bydrectest.R
import com.edwinacubillos.bydrectest.adapters.ResultsAdapter
import com.edwinacubillos.bydrectest.model.results.Results
import kotlinx.android.synthetic.main.fragment_results.view.*

class ResultsFragment : Fragment(), ResultsContract.view {

    private lateinit var presenter: ResultsContract.presenter
    private lateinit var viewFragment: View

    private var listResults = listOf<Results>()

    private lateinit var rvResults: RecyclerView
    private lateinit var resultsAdapter: ResultsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewFragment = inflater.inflate(R.layout.fragment_results, container, false)

        presenter = ResultsPresenter(this)

        presenter.loadResults()

        return viewFragment
    }

    override fun showResults(listResults: List<Results>?) {
        this.listResults = listResults!!

        rvResults = viewFragment.rvResults
        rvResults.layoutManager = LinearLayoutManager(
            BydRecTest.mInstance.getContext(),
            RecyclerView.VERTICAL, false
        )
        resultsAdapter = ResultsAdapter(listResults)
        rvResults.adapter = resultsAdapter
    }
}
