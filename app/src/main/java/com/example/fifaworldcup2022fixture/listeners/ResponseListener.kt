package com.example.soccerzone.listeners

import com.example.fifaworldcup2022fixture.models.FixModel

interface ResponseListener {
    fun didFetch(response: FixModel, message: String)
    fun didError(message: String)
}