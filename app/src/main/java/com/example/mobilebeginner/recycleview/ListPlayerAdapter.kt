package com.example.mobilebeginner.recycleview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilebeginner.R

//  TODO: 14. Make Adapter for Recycle View
class ListPlayerAdapter(private val listPlayer: ArrayList<Player>) :
    RecyclerView.Adapter<ListPlayerAdapter.ListViewHolder>() {

    //  declare the variable for click item
    private lateinit var onItemClickCallBack: OnItemClickCallback

    //  make this function for trigger from activity
    fun setOnItemClickCallBack(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallBack = onItemClickCallback
    }

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
        //  TODO: 18. Make click for item in Recycleview
        holder.itemView.setOnClickListener {
            Log.d(TAG, listPlayer[holder.adapterPosition].name)
            //  call function
            onItemClickCallBack.onItemClicked(listPlayer[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int = listPlayer.size

    //  TODO: 15. Make class for RecycleView Adapter
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.iv_player_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_player_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_player_description)
    }

    //  make interface to declare itemClick
    interface OnItemClickCallback {
        //  make function itemclick
        fun onItemClicked(data: Player)
    }

    companion object {
        const val TAG = "Recycle View"
    }
}