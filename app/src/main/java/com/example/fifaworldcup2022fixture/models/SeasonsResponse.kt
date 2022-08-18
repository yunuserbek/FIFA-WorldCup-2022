package com.example.soccerzone.models

import com.example.fifaworldcup2022fixture.models.Pagination

class SeasonsResponse {
    var data: List<SeasonData> = listOf()
    lateinit var pagination: Pagination
}