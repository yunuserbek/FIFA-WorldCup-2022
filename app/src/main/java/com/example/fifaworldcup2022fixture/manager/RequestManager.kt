package com.example.soccerzone.manager

import android.content.Context
import com.example.soccerzone.listeners.ResponseListener
import com.example.soccerzone.models.FixtureResponse
import com.example.soccerzone.models.SeasonsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

class RequestManager(context: Context) {
    var retrofit = Retrofit.Builder()
        .baseUrl("https://elenasport-io1.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getAllFixtures(listener: ResponseListener<FixtureResponse>, id: Int, page: Int){
        val call = retrofit.create(CallSeasonFixtures::class.java).callSeasonFixtures(id, page)
        call.enqueue(object : Callback<FixtureResponse> {
            override fun onResponse(
                call: Call<FixtureResponse>,
                response: Response<FixtureResponse>
            ) {
                if (!response.isSuccessful){
                    listener.didError(response.message())
                    return
                }
                response.body()?.let { listener.didFetch(it, response.message()) }
            }

            override fun onFailure(call: Call<FixtureResponse>, t: Throwable) {
                t.message?.let { listener.didError(it) }
            }

        })
    }
    interface CallSeasonFixtures {
        @GET("v2/seasons/{id}/fixtures")
        @Headers(
            "Accept: application/json",
            "X-RapidAPI-Host: elenasport-io1.p.rapidapi.com",
            "X-RapidAPI-Key: 911311298cmsh7a078bde839f805p166501jsn304a10b39353"
        )
        fun callSeasonFixtures(
            @Path("id") path: Int,
            @Query("page") page: Int
        ): Call<FixtureResponse>
    }

}