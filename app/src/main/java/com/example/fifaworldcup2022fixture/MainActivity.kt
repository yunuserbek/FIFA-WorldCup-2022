package com.example.fifaworldcup2022fixture

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fifaworldcup2022fixture.adapter.FixturesRecyclerAdapter
import com.example.fifaworldcup2022fixture.databinding.ActivityMainBinding
import com.example.fifaworldcup2022fixture.models.FixModel
import com.example.soccerzone.listeners.ResponseListener
import com.example.soccerzone.manager.RequestManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    lateinit var manager: RequestManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        manager = RequestManager()
        manager.getAllFixtures(fixtureResponseListener, 1331, 1)

    }

    private val fixtureResponseListener: ResponseListener = object :
        ResponseListener {
        override fun didFetch(response: FixModel, message: String) {

            binding.recyclerDetails.setHasFixedSize(true)
            binding.recyclerDetails.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            var fixtureAdapter: FixturesRecyclerAdapter = FixturesRecyclerAdapter(response.data)
            binding.recyclerDetails.adapter = fixtureAdapter
        }

        override fun didError(message: String) {
           TODO()
        }

    }



}