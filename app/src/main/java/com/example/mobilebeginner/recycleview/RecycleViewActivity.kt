package com.example.mobilebeginner.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilebeginner.R

class RecycleViewActivity : AppCompatActivity() {

    //  declaration component
    private lateinit var rvPlayer: RecyclerView
    private val player = ArrayList<Player>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycle_view)

        //  call recycle view to connect our component
        rvPlayer = findViewById(R.id.rv_nba_player)
        rvPlayer.setHasFixedSize(true)

        //  store all value to variable player and call show recycle list to activity
        player.addAll(getListPlayers())
        showRecycleList()
    }

    private fun showRecycleList() {
        //  TODO: 17. Make LayoutManager for RecycleView
        rvPlayer.layoutManager = LinearLayoutManager(this)
        val listPlayerAdapter = ListPlayerAdapter(player)
        rvPlayer.adapter = listPlayerAdapter

        //  TODO: 19. Make item for click it
        listPlayerAdapter.setOnItemClickCallBack(object : ListPlayerAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Player) {
                //  showSelectedPlayer(data)
                Log.d("RV Activity", "This is ${data.name}")
            }

        })
    }

    private fun getListPlayers(): ArrayList<Player> {
        //  TODO: 16. Store the value with ArrayList to our variable
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listPlayers = ArrayList<Player>()
        for (i in dataName.indices) {
            val player = Player(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1))
            listPlayers.add(player)
        }

        return listPlayers
    }
}