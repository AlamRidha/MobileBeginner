package com.example.mobilebeginner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  declaration for button to move activity
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        //  declaration for button to move activity with data
        val btnMoveActivityData: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveActivityData.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //  make condition for button
        when (v?.id) {
            R.id.btn_move_activity -> {
                //  make navigation use Explicit Intent
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                val moveIntentData = Intent(this@MainActivity, MoveActivityWithData::class.java)
                //  put extra to save the data with Key-Value
                moveIntentData.putExtra(MoveActivityWithData.EXTRA_NAME, "Muhammad Allam Ridha")
                moveIntentData.putExtra(MoveActivityWithData.EXTRA_AGE, 21)
                startActivity(moveIntentData)
            }
        }
    }
}