package com.edwinacubillos.bydrectest.model.fixtures

import com.google.gson.annotations.SerializedName

data class CompetitionStage(
    @SerializedName("competition")
    val competition: Competition
)
