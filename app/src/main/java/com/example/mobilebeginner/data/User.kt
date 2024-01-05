package com.example.mobilebeginner.data

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//  function data class is to save data model (attribute) of an object
//  data class is same like at Java -> setter and getter
//  TODO: 5. Create data class
@Parcelize
data class User(
    val name: String?,
    val age: Int?,
    val email: String?,
    val city: String?
) : Parcelable
//  Parcelable an interface that allows us to send one object at a time from one Activity to another Activity.
//  When we have added the Parcelize plugin, we only need to add the Parcelize annotation above Parcelable
//{
//    constructor(parcel: Parcel) : this(
//        parcel.readString(),
//        parcel.readValue(Int::class.java.classLoader) as? Int,
//        parcel.readString(),
//        parcel.readString()
//    ) {
//    }
//
//    override fun writeToParcel(parcel: Parcel, flags: Int) {
//        parcel.writeString(name)
//        parcel.writeValue(age)
//        parcel.writeString(email)
//        parcel.writeString(city)
//    }
//
//    override fun describeContents(): Int {
//        return 0
//    }
//
//    companion object CREATOR : Parcelable.Creator<User> {
//        override fun createFromParcel(parcel: Parcel): User {
//            return User(parcel)
//        }
//
//        override fun newArray(size: Int): Array<User?> {
//            return arrayOfNulls(size)
//        }
//    }
//}

