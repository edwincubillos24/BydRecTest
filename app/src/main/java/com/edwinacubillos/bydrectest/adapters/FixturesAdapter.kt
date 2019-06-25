package com.edwinacubillos.bydrectest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.bydrectest.BydRecTest
import com.edwinacubillos.bydrectest.R
import com.edwinacubillos.bydrectest.model.fixtures.Fixtures
import com.edwinacubillos.bydrectest.utils.Constants
import com.edwinacubillos.bydrectest.utils.DateConverter
import kotlinx.android.synthetic.main.fixture_item.view.*

class FixturesAdapter : RecyclerView.Adapter<FixturesAdapter.FixturesViewHolder> {

    private var listFixtures: List<Fixtures>? = null

    constructor(listFixtures: List<Fixtures>) {
        this.listFixtures = listFixtures
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixturesViewHolder {
        var view = LayoutInflater.from(BydRecTest.mInstance.getContext()).inflate(R.layout.fixture_item, parent, false)
        return FixturesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listFixtures?.size!!
    }

    override fun onBindViewHolder(holder: FixturesViewHolder, position: Int) {
        var fixtures = listFixtures!![position]
        holder.loadItem(fixtures)
    }

    class FixturesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun loadItem(fixtures: Fixtures) {
            itemView.tCompetitionName.text = fixtures.competitionStage.competition.name
            itemView.tVenueName?.text = fixtures.venue.name
            itemView.tMatchDateTime?.text =
                DateConverter().extractDate(fixtures.date) + " at " + DateConverter().extractTime(fixtures.date)
            itemView.tHomeTeam?.text = fixtures.homeTeam.name
            itemView.tAwayTeam?.text = fixtures.awayTeam.name
            itemView.tDay?.text = DateConverter().extractDay(fixtures.date)
            itemView.tDate?.text = DateConverter().extractDateOnly(fixtures.date)
            if (fixtures.state.equals(Constants.PREMATCH)) {
                itemView.tPostponed.visibility = View.GONE
                itemView.tMatchDateTime.setTextColor(ContextCompat.getColor(BydRecTest.mInstance.getContext()!!, R.color.black))
            } else {
                itemView.tPostponed.visibility = View.VISIBLE
                itemView.tMatchDateTime.setTextColor(ContextCompat.getColor(BydRecTest.mInstance.getContext()!!, R.color.red))
            }
        }
    }
}
