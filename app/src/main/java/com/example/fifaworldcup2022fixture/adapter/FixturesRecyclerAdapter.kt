package com.example.fifaworldcup2022fixture.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fifaworldcup2022fixture.R
import com.example.soccerzone.listeners.ClickListener
import com.example.soccerzone.models.Fixture
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class FixturesRecyclerAdapter(val context: Context, val list: List<Fixture>, val listener: ClickListener<Fixture>)
    : RecyclerView.Adapter<FixturesViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixturesViewHolder {
        val layout = LayoutInflater.from(context).inflate(R.layout.item_fixture, parent, false)
        return FixturesViewHolder(layout)
    }

    override fun onBindViewHolder(holder: FixturesViewHolder, position: Int) {
        val item = list.get(holder.adapterPosition)

       Picasso.get().load("https://countryflagsapi.com/png/" + item.homeName).placeholder(R.drawable.img).into(holder.imageView_home)
       Picasso.get().load("https://countryflagsapi.com/png/" + item.awayName).placeholder(R.drawable.img).into(holder.imageView_away)

        holder.textView_home.text = item.homeName
        holder.textView_away.text = item.awayName

        holder.textView_match.text = item.homeName + " vs " + item.awayName


        val dateFormatter = SimpleDateFormat("EEE, d MMM")
        val timeFormatter = SimpleDateFormat("hh:mm a")
        val date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(item.date)

        holder.textView_time.text = dateFormatter.format(date) + "\n" + timeFormatter.format(date)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}
class FixturesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var imageView_home: ImageView = itemView.findViewById(R.id.imageView_home)
    var imageView_away: ImageView = itemView.findViewById(R.id.imageViewaway)
    var textView_home: TextView = itemView.findViewById(R.id.textView_home)
    var textView_away: TextView = itemView.findViewById(R.id.textView_away)
    var textView_time: TextView = itemView.findViewById(R.id.textViewTime)
    var textView_match: TextView = itemView.findViewById(R.id.textView_match)


}