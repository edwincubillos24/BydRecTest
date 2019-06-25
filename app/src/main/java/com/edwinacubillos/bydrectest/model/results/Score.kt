package com.edwinacubillos.bydrectest.model.results

import com.google.gson.annotations.SerializedName

data class Score(
    @SerializedName("away")
    val away: Int,
    @SerializedName("home")
    val home: Int
)
