package com.example.fifaworldcup2022fixture.di

import com.example.fifaworldcup2022fixture.models.Data
import com.example.fifaworldcup2022fixture.models.FixModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiServiceFixture {
    @GET("v2/seasons/{id}/fixtures")
    @Headers(
        "Accept: application/json",
        "X-RapidAPI-Host: elenasport-io1.p.rapidapi.com",
        "X-RapidAPI-Key: 911311298cmsh7a078bde839f805p166501jsn304a10b39353"
    )
   suspend fun callSeasonFixtures(
        @Path("id") path: Int,
        @Query("page") page: Int
    ): Response<FixModel>
}




