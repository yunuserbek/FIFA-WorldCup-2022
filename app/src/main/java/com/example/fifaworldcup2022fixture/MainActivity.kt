package com.example.fifaworldcup2022fixture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fifaworldcup2022fixture.adapter.FixturesRecyclerAdapter

import com.example.fifaworldcup2022fixture.databinding.ActivityMainBinding
import com.example.soccerzone.listeners.ClickListener
import com.example.soccerzone.listeners.ResponseListener
import com.example.soccerzone.manager.RequestManager
import com.example.soccerzone.models.Fixture
import com.example.soccerzone.models.FixtureResponse
import com.example.soccerzone.models.SeasonData
import com.example.soccerzone.models.SeasonsResponse
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    lateinit var manager: RequestManager
    var seasonList: MutableList<SeasonData> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        manager = RequestManager(this)
        manager.getAllFixtures(fixtureResponseListener, 1331, 1)

    }

    private val fixtureResponseListener: ResponseListener<FixtureResponse> = object :
        ResponseListener<FixtureResponse> {
        override fun didFetch(response: FixtureResponse, message: String) {

            binding.recyclerDetails.setHasFixedSize(true)
            binding.recyclerDetails.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            var fixtureAdapter: FixturesRecyclerAdapter = FixturesRecyclerAdapter(this@MainActivity, response.data, itemClickListener)
            binding.recyclerDetails.adapter = fixtureAdapter
        }

        override fun didError(message: String) {
           TODO()
        }

    }

    private val itemClickListener: ClickListener<Fixture> = object : ClickListener<Fixture> {
        override fun onClicked(data: Fixture) {
            Toast.makeText(this@MainActivity, data.awayName, Toast.LENGTH_LONG).show()
        }

    }

}