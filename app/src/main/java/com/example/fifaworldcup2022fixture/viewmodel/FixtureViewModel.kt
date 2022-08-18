package com.example.fifaworldcup2022fixture.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.fifaworldcup2022fixture.models.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class FixtureViewModel @Inject constructor() : ViewModel() {
    /*
    val datafix = MutableLiveData<List<Data>>()
init {
   getFixture()
}
    private fun getFixture() {
        apiServiceFixture.callSeasonFixtures(1331,1).enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        datafix.value = it
                        it.forEach {
                            println(it.homeName)
                        }



                    }
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                t.printStackTrace()
            }

        })

    }

     */


}