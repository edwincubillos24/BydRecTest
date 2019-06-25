package com.edwinacubillos.bydrectest.results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edwinacubillos.bydrectest.BydRecTest
import com.edwinacubillos.bydrectest.R
import com.edwinacubillos.bydrectest.adapters.ResultAdapter
import com.edwinacubillos.bydrectest.model.results.Results
import com.edwinacubillos.bydrectest.utils.DateConverter
import com.jaychang.srv.SimpleRecyclerView
import com.jaychang.srv.decoration.SimpleSectionHeaderProvider
import kotlinx.android.synthetic.main.fragment_results.view.*
import kotlinx.android.synthetic.main.header.view.*

class ResultsFragment : Fragment(), ResultsContract.view {

    private lateinit var presenter: ResultsContract.presenter
    private lateinit var viewFragment: View

    private var listResults = listOf<Results>()

    private lateinit var simpleRecyclerView: SimpleRecyclerView

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

        simpleRecyclerView = viewFragment.rvResults

        addRecyclerHeaders()
        bindData()
    }

    private fun addRecyclerHeaders() {
        val sh = object : SimpleSectionHeaderProvider<Results>() {
            override fun getSectionHeaderView(results: Results, i: Int): View {
                var view = LayoutInflater.from(BydRecTest.mInstance.getContext()).inflate(R.layout.header, null, false)
                view.tHeader.text = DateConverter().extractMonthOnly(results.date)
                return view
            }

            override fun isSameSection(results: Results, nextFixture: Results): Boolean {
                return DateConverter().extractMonthOnly(results.date) == DateConverter().extractMonthOnly(results.date)
            }

            override fun isSticky(): Boolean {
                return true
            }
        }
        simpleRecyclerView.setSectionHeader(sh)
    }

    private fun bindData() {
        val cells = ArrayList<ResultAdapter>()
        for (fixtures in listResults) {
            val cell = ResultAdapter(fixtures)
            cells.add(cell)
        }
        simpleRecyclerView.addCells(cells)
    }
}
