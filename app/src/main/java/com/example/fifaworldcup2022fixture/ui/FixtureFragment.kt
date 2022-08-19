package com.example.fifaworldcup2022fixture.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fifaworldcup2022fixture.adapter.FixturesRecyclerAdapter
import com.example.fifaworldcup2022fixture.databinding.FragmentFixtureBinding
import com.example.fifaworldcup2022fixture.models.FixModel
import com.example.fifaworldcup2022fixture.viewmodel.FixtureViewModel
import com.example.soccerzone.listeners.ResponseListener
import com.example.soccerzone.manager.RequestManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FixtureFragment : Fragment() {
    private lateinit var binding: FragmentFixtureBinding
    //lateinit var manager: RequestManager
    private val adapter: FixturesRecyclerAdapter by lazy { FixturesRecyclerAdapter() }
    private val manager:RequestManager by lazy { RequestManager() }
    //private val viewModel: FixtureViewModel by viewModels()

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
      //  manager = RequestManager()
        manager.getAllFixtures(fixtureResponseListener, 1331, 1)



    }

    private val fixtureResponseListener: ResponseListener = object :
        ResponseListener {
        override fun didFetch(response: FixModel, message: String) {

            binding.recyclerDetails.setHasFixedSize(true)
            binding.recyclerDetails.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter.differ.submitList(response.data)
            binding.recyclerDetails.adapter = adapter
        }

        override fun didError(message: String) {
            TODO()
        }

    }
    }

