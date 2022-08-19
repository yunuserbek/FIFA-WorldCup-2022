package com.example.fifaworldcup2022fixture.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fifaworldcup2022fixture.R
import com.example.fifaworldcup2022fixture.databinding.ItemFixtureBinding
import com.example.fifaworldcup2022fixture.models.Data
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat

class FixturesRecyclerAdapter(val list: List<Data>) :
    RecyclerView.Adapter<FixturesRecyclerAdapter.FixturesViewHolder>() {
    inner class FixturesViewHolder(val binding: ItemFixtureBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

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
        val item = list[position]
        Picasso.get().load("https://countryflagsapi.com/png/" + item.homeName)
            .placeholder(R.drawable.img).into(holder.binding.imageViewHome)
        Picasso.get().load("https://countryflagsapi.com/png/" + item.awayName)
            .placeholder(R.drawable.img).into(holder.binding.imageViewaway)


        holder.binding.textViewHome.text = item.homeName
        holder.binding.textViewAway.text = item.awayName
        holder.binding.textViewMatch.text = item.homeName + " vs " + item.awayName
        val dateFormatter = SimpleDateFormat("EEE, d MMM")
        val timeFormatter = SimpleDateFormat("hh:mm a")
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(item.date)

        holder.binding.textViewTime.text =
            dateFormatter.format(date) + "\n" + timeFormatter.format(date)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}
