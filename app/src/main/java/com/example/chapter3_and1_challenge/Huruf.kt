package com.example.chapter3_and1_challenge

import android.os.Parcel
import android.os.Parcelable

data class Huruf(val huruf: Char, val kata: ArrayList<String>) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt().toChar(),
        parcel.createStringArrayList()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(huruf.toInt())
        parcel.writeStringList(kata)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Huruf> {
        override fun createFromParcel(parcel: Parcel): Huruf {
            return Huruf(parcel)
        }

        override fun newArray(size: Int): Array<Huruf?> {
            return arrayOfNulls(size)
        }
    }
}
