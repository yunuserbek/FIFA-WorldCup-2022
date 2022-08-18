package com.example.fifaworldcup2022fixture.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fifaworldcup2022fixture.databinding.ItemFixtureBinding
import com.example.fifaworldcup2022fixture.models.Data
import com.example.soccerzone.models.Fixture

class FixtureAdapter:RecyclerView.Adapter<FixtureAdapter.FixtureViewHolder>() {
    class FixtureViewHolder(val binding: ItemFixtureBinding): RecyclerView.ViewHolder(binding.root)
    var fixtur = emptyList<Fixture>()

    private val differCallback = object : DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this,differCallback)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureViewHolder {
        return FixtureViewHolder(ItemFixtureBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FixtureViewHolder, position: Int) {
        //val currentFixture =differ.currentList[position]
        val data = fixtur[position]
        holder.binding.textViewHome.text = data.homeName

       // Picasso.get().load("https://countryflagsapi.com/png/" + currentFixture.homeName!!.lowercase()).into(binding?.imageViewHome)
        //Picasso.get().load("https://countryflagsapi.com/png/" + currentFixture.awayName!!.lowercase()).into(binding?.imageViewaway)
        //binding?.textViewHome?.text = currentFixture.homeName
      //  binding?.textViewAway?.text = currentFixture.awayName
     //   binding?.textViewMatch?.text = currentFixture.homeName + "vs"+ currentFixture.awayName
    }

    override fun getItemCount() = differ.currentList.size
    fun setData(newData: List<Fixture>){
        fixtur = newData
        notifyDataSetChanged()
    }



}