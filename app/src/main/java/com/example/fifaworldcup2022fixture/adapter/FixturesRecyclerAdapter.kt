package com.example.fifaworldcup2022fixture.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.fifaworldcup2022fixture.R
import com.example.fifaworldcup2022fixture.databinding.ItemFixtureBinding
import com.example.fifaworldcup2022fixture.models.Data
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat

class FixturesRecyclerAdapter() :
    RecyclerView.Adapter<FixturesRecyclerAdapter.FixturesViewHolder>() {
    inner class FixturesViewHolder(val binding: ItemFixtureBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }


    private val differCallback = object : DiffUtil.ItemCallback<Data>(){
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this,differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixturesViewHolder {
        return FixturesViewHolder(
            ItemFixtureBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FixturesViewHolder, position: Int) {
        val differ = differ.currentList[position]
        Picasso.get().load("https://countryflagsapi.com/png/" + differ.homeName)
            .placeholder(R.drawable.img).into(holder.binding.imageViewHome)
        Picasso.get().load("https://countryflagsapi.com/png/" + differ.awayName)
            .placeholder(R.drawable.img).into(holder.binding.imageViewaway)


        holder.binding.textViewHome.text = differ.homeName
        holder.binding.textViewAway.text = differ.awayName
        holder.binding.textViewMatch.text = differ.homeName + " vs " + differ.awayName
        val dateFormatter = SimpleDateFormat("EEE, d MMM")
        val timeFormatter = SimpleDateFormat("hh:mm a")
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(differ.date)

        holder.binding.textViewTime.text =
            dateFormatter.format(date) + "\n" + timeFormatter.format(date)

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
}
