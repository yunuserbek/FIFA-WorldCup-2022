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
import com.example.fifaworldcup2022fixture.viewmodel.FixtureViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FixtureFragment : Fragment() {
    private lateinit var binding: FragmentFixtureBinding
    private val adapter: FixturesRecyclerAdapter by lazy { FixturesRecyclerAdapter() }
    private val viewModel: FixtureViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFixtureBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRv()
    }

    private fun setRv() {
        binding.recyclerDetails.setHasFixedSize(true)
        binding.recyclerDetails.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        viewModel.dataResponse.observe(viewLifecycleOwner) { response ->
            adapter.differ.submitList(response)
            binding.recyclerDetails.adapter = adapter
        }

    }

}


