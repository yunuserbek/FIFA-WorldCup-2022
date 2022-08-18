package com.example.soccerzone.models

import com.example.fifaworldcup2022fixture.models.Pagination

class FixtureResponse {
    lateinit var data: List<Fixture>
    lateinit var pagination: Pagination
}