package com.example.fifaworldcup2022fixture.models


import com.google.gson.annotations.SerializedName

data class FixModel(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("pagination")
    val pagination: Pagination?
)