package com.edwinacubillos.bydrectest.fixtures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.edwinacubillos.bydrectest.BydRecTest
import com.edwinacubillos.bydrectest.R
import com.edwinacubillos.bydrectest.adapters.FixtureAdapter
import com.edwinacubillos.bydrectest.model.fixtures.Fixtures
import com.edwinacubillos.bydrectest.utils.DateConverter
import com.jaychang.srv.SimpleRecyclerView
import com.jaychang.srv.decoration.SimpleSectionHeaderProvider
import kotlinx.android.synthetic.main.fragment_fixtures.view.*
import kotlinx.android.synthetic.main.header.view.*

class FixturesFragment : Fragment(), FixturesContract.View {

    private lateinit var presenter: FixturesContract.Presenter
    private lateinit var viewFragment: View

    private var listFixtures = listOf<Fixtures>()

    private lateinit var simpleRecyclerView: SimpleRecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewFragment = inflater.inflate(R.layout.fragment_fixtures, container, false)

        presenter = FixturesPresenter(this)

        presenter.loadFixtures()

        return viewFragment
    }

    override fun showFixtures(listFixtures: List<Fixtures>?) {
        this.listFixtures = listFixtures!!

        simpleRecyclerView = viewFragment.rvFixtures

        addRecyclerHeaders()
        bindData()
    }

    private fun addRecyclerHeaders() {
        val sh = object : SimpleSectionHeaderProvider<Fixtures>() {
            override fun getSectionHeaderView(fixtures: Fixtures, i: Int): View {
                var view = LayoutInflater.from(BydRecTest.mInstance.getContext()).inflate(R.layout.header, null, false)
                view.tHeader.text = DateConverter().extractMonthOnly(fixtures.date)
                return view
            }

            override fun isSameSection(fixtures: Fixtures, nextFixture: Fixtures): Boolean {
                return DateConverter().extractMonthOnly(fixtures.date) == DateConverter().extractMonthOnly(fixtures.date)
            }

            override fun isSticky(): Boolean {
                return true
            }
        }
        simpleRecyclerView.setSectionHeader(sh)
    }

    private fun bindData() {
        val cells = ArrayList<FixtureAdapter>()
        for (fixtures in listFixtures) {
            val cell = FixtureAdapter(fixtures)
            cells.add(cell)
        }
        simpleRecyclerView.addCells(cells)
    }
}
