package com.example.fifaworldcup2022fixture.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fifaworldcup2022fixture.di.ApiServiceFixture
import com.example.fifaworldcup2022fixture.models.Data
import com.example.fifaworldcup2022fixture.models.FixModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class FixtureViewModel @Inject constructor(val apiServiceFixture: ApiServiceFixture) : ViewModel() {
    val dataResponse = MutableLiveData<List<Data>>()

    init {
        getAllFixtures()
    }

    private fun getAllFixtures() {
        viewModelScope.launch {
            val response = apiServiceFixture.callSeasonFixtures(1331,1)
            if (response.isSuccessful){
                dataResponse.value = response.body()!!.data
            }
        }
        
    }



}