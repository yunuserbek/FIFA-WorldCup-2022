package com.example.fifaworldcup2022fixture.models


import com.google.gson.annotations.SerializedName

data class Pagination(
    @SerializedName("hasNextPage")
    val hasNextPage: Boolean?,
    @SerializedName("hasPrevPage")
    val hasPrevPage: Boolean?,
    @SerializedName("itemsPerPage")
    val itemsPerPage: Int?,
    @SerializedName("page")
    val page: Int?
)