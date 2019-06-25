package com.edwinacubillos.bydrectest.model.results

import com.google.gson.annotations.SerializedName

data class AggregateScore(
    @SerializedName("away")
    val away: Int,
    @SerializedName("home")
    val home: Int,
    @SerializedName("winner")
    val winner: String
)
