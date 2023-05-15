package com.example.modul4intentex5kotlin.modul

import android.os.Parcel
import android.os.Parcelable

class User(var age: Int, var name: String?) : Parcelable {

    // Constructor, getters, and setters

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
    )

    // Implement the Parcelable methods
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(age)
        dest.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "User{" +
                "age='" + age + '\'' +
                ", name=" + name +
                '}'
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}