package com.example.mobilebeginner

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.mobilebeginner.data.User
import com.example.mobilebeginner.recycleview.RecycleViewActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView

    //  TODO: 11. Use result launcher to get value from another activity
    //  To make a activity have return value, we must make the object ActivityResultLauncher first
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //  declaration for button to move activity
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        //  declaration for button to move activity with data
        val btnMoveActivityData: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveActivityData.setOnClickListener(this)

        //  declaration for button to move activity with object
        val btnMoveActivityObject: Button = findViewById(R.id.btn_move_activity_object)
        btnMoveActivityObject.setOnClickListener(this)

        //  declaration for button to use implicit intent
        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        //  declaration for button and textview to use move activity for result
        val btnActivityResult: Button = findViewById(R.id.btn_move_for_result)
        btnActivityResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_move_for_result)

        //  declaration for button to move activity with recycle view
        val btnRecycleView: Button = findViewById(R.id.btn_move_rv)
        btnRecycleView.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        //  make condition for button
        when (v?.id) {
            R.id.btn_move_activity -> {
                // TODO: 1. Make navigation use Explicit Intent
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }

            R.id.btn_move_activity_data -> {
                val moveIntentData = Intent(this@MainActivity, MoveActivityWithData::class.java)
                // TODO: 4 Send data using put extra to save the data with Key-Value
                moveIntentData.putExtra(MoveActivityWithData.EXTRA_NAME, "Muhammad Allam Ridha")
                moveIntentData.putExtra(MoveActivityWithData.EXTRA_AGE, 21)
                startActivity(moveIntentData)
            }

            R.id.btn_move_activity_object -> {
                //  TODO: 8. Make object
                val user = User(
                    "Muhammad Allam Ridha",
                    21,
                    "orarytemp@gmail.com",
                    "Riau"
                )

                val moveIntentObject = Intent(this@MainActivity, MoveActivityObject::class.java)
                //  TODO: 9. Send data with putExtra
                moveIntentObject.putExtra(MoveActivityObject.EXTRA_USER, user)
                startActivity(moveIntentObject)
            }

            R.id.btn_dial_number -> {
                // TODO: 10. Make intent to move activity with implicit Intent
                val phone = "0812345678910"
                val dialIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phone"))
                startActivity(dialIntent)
            }

            R.id.btn_move_for_result -> {
                // TODO: 12. Make intent then call resultLauncher
                val moveForResultIntent =
                    Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }

            R.id.btn_move_rv ->{
                val moveRvIntent = Intent(this@MainActivity, RecycleViewActivity::class.java)
                startActivity(moveRvIntent)
            }
        }
    }
}