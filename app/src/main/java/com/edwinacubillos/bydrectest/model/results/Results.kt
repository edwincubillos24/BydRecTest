package com.edwinacubillos.bydrectest.model.results

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("aggregateScore")
    val aggregateScore: AggregateScore,
    @SerializedName("awayTeam")
    val awayTeam: AwayTeam,
    @SerializedName("competitionStage")
    val competitionStage: CompetitionStage,
    @SerializedName("date")
    val date: String,
    @SerializedName("homeTeam")
    val homeTeam: HomeTeam,
    @SerializedName("id")
    val id: Int,
    @SerializedName("penaltyScore")
    val penaltyScore: PenaltyScore,
    @SerializedName("score")
    val score: Score,
    @SerializedName("state")
    val state: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("venue")
    val venue: Venue
)
