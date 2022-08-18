package com.example.fifaworldcup2022fixture.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fifaworldcup2022fixture.adapter.FixtureAdapter
import com.example.fifaworldcup2022fixture.databinding.FragmentFixtureBinding
import com.example.fifaworldcup2022fixture.viewmodel.FixtureViewModel
import com.example.soccerzone.listeners.ResponseListener
import com.example.soccerzone.manager.RequestManager
import com.example.soccerzone.models.FixtureResponse
import com.example.soccerzone.models.SeasonData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FixtureFragment : Fragment() {
    private lateinit var binding: FragmentFixtureBinding
    lateinit var manager: RequestManager
    private val viewModel: FixtureViewModel by viewModels()
   // private lateinit var fixtureAdapter: FixtureAdapter
    private val adapter: FixtureAdapter by lazy { FixtureAdapter() }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFixtureBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        manager = RequestManager(requireContext())
        manager.getAllFixtures(fixtureResponseListener, 1331, 1)



    }
    private val fixtureResponseListener: ResponseListener<FixtureResponse> = object :
        ResponseListener<FixtureResponse> {
        override fun didFetch(response: FixtureResponse, message: String) {
            binding.recyclerFixture.setHasFixedSize(true)
            binding.recyclerFixture.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
           adapter.setData(response.data)
            binding.recyclerFixture.adapter = adapter
        }

    private fun setupRv() {


//
       // viewModel.datafix.observe(viewLifecycleOwner) {data->
       //     binding.recyclerFixture.layoutManager = GridLayoutManager(requireContext(),1)
      //     adapter.setData(data)
        //    binding.recyclerFixture.adapter = adapter

           }

        override fun didError(message: String) {
            TODO("Not yet implemented")
        }


    }
    }

