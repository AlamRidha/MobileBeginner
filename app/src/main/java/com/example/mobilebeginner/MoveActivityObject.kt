package com.example.mobilebeginner

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.mobilebeginner.data.User

class MoveActivityObject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_object)

        val tvObject: TextView = findViewById(R.id.tv_object_received)

        // TODO: 7. Get object from another activity use getParacelableExtra
        val user = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_USER, User::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_USER)
        }

        if (user != null) {
            val text =
                "Name : ${user.name.toString()}, \nEmail ${user.email.toString()}, \nAge ${user.age.toString()} \nCity ${user.city.toString()}"
            tvObject.text = text
        }

    }

    //  TODO: 6. Make companion object for default value
    companion object {
        const val EXTRA_USER = "extra_user"
    }
}