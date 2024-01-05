package com.example.mobilebeginner.recycleview

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//  TODO: 13. Make Object Player
@Parcelize
data class Player(
    val name: String,
    val description: String,
    val photo: Int
): Parcelable