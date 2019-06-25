package com.edwinacubillos.bydrectest.model.results

import com.google.gson.annotations.SerializedName

data class CompetitionStage(
    @SerializedName("competition")
    val competition: Competition,
    @SerializedName("stage")
    val stage: String
)
