package com.edwinacubillos.bydrectest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.edwinacubillos.bydrectest.BydRecTest
import com.edwinacubillos.bydrectest.R
import com.edwinacubillos.bydrectest.model.results.Results
import com.edwinacubillos.bydrectest.utils.DateConverter
import kotlinx.android.synthetic.main.results_item.view.*

class ResultsAdapter : RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder> {

    private var listResults: List<Results>? = null

    constructor(listResults: List<Results>) {
        this.listResults = listResults
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        var view = LayoutInflater.from(BydRecTest.mInstance.getContext()).inflate(R.layout.results_item, parent, false)
        return ResultsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listResults?.size!!
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        var results = listResults!![position]
        holder.loadItem(results)
    }

    class ResultsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun loadItem(results: Results) {
            itemView.tCompetitionName?.text = results.competitionStage.competition.name
            itemView.tVenueName?.text = results.venue.name
            itemView.tMatchDateTime?.text =
                DateConverter().extractDate(results.date) + " at " + DateConverter().extractTime(results.date)
            itemView.tHomeTeam?.text = results.homeTeam.name
            itemView.tAwayTeam?.text = results.awayTeam.name
            itemView.tHomeScore?.text = results.score.home.toString()
            itemView.tAwayScore?.text = results.score.away.toString()

            if (results.score.home > results.score.away) {
                itemView.tHomeScore.setTextColor(
                    ContextCompat.getColor(
                        BydRecTest.mInstance.getContext()!!,
                        R.color.blue
                    )
                )
            } else if (results.score.home < results.score.away) {
                itemView.tAwayScore.setTextColor(
                    ContextCompat.getColor(
                        BydRecTest.mInstance.getContext()!!,
                        R.color.blue
                    )
                )
            } else {
                itemView.tAwayScore.setTextColor(
                    ContextCompat.getColor(
                        BydRecTest.mInstance.getContext()!!,
                        R.color.black
                    )
                )
                itemView.tHomeScore.setTextColor(
                    ContextCompat.getColor(
                        BydRecTest.mInstance.getContext()!!,
                        R.color.black
                    )
                )
            }
        }
    }
}
