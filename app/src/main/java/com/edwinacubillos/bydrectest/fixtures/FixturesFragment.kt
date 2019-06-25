package com.edwinacubillos.bydrectest.fixtures

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.bydrectest.BydRecTest
import com.edwinacubillos.bydrectest.R
import com.edwinacubillos.bydrectest.adapters.FixturesAdapter
import com.edwinacubillos.bydrectest.model.fixtures.Fixtures
import kotlinx.android.synthetic.main.fragment_fixtures.view.*

class FixturesFragment : Fragment(), FixturesContract.View {

    private lateinit var presenter: FixturesContract.Presenter
    private lateinit var viewFragment: View

    private var listFixtures = listOf<Fixtures>()

    private lateinit var rvFixtures: RecyclerView
    private lateinit var fixturesAdapter: FixturesAdapter

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

        rvFixtures = viewFragment.rvFixtures
        rvFixtures.layoutManager = LinearLayoutManager(
            BydRecTest.mInstance.getContext(),
            RecyclerView.VERTICAL, false
        )

        fixturesAdapter = FixturesAdapter(listFixtures)
        rvFixtures.adapter = fixturesAdapter
    }
}
