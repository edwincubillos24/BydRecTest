package com.edwinacubillos.bydrectest.model.fixtures

import com.google.gson.annotations.SerializedName

data class Fixtures(
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
    @SerializedName("state")
    val state: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("venue")
    val venue: Venue
)
