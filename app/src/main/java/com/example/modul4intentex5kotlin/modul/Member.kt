package com.example.modul4intentex5kotlin.modul

import android.os.Parcel
import android.os.Parcelable

class Member(var id: Int, var name: String?) : Parcelable {

    // Constructor, getters, and setters

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
    )

    // Implement the Parcelable methods
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeInt(id)
        dest.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "User{" +
                "id='" + id + '\'' +
                ", name=" + name +
                '}'
    }

    companion object CREATOR : Parcelable.Creator<Member> {
        override fun createFromParcel(parcel: Parcel): Member {
            return Member(parcel)
        }

        override fun newArray(size: Int): Array<Member?> {
            return arrayOfNulls(size)
        }
    }
}