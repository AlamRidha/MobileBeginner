package com.example.mobilebeginner.recycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilebeginner.R

//  TODO: 14. Make Adapter for Recycle View
class ListPlayerAdapter(private val listPlayer: ArrayList<Player>) :
    RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListPlayerAdapter.ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_player, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListPlayerAdapter.ListViewHolder, position: Int) {
        val (name, description, photo) = listPlayer[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
    }

    override fun getItemCount(): Int = listPlayer.size

    //  TODO: 15. Make class for RecycleView Adapter
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_player_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_player_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_player_description)
    }
}