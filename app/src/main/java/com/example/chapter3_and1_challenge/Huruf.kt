package com.example.chapter3_and1_challenge

import android.os.Parcel
import android.os.Parcelable

data class Huruf(val huruf : Char, val kata : ArrayList<String>) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt().toChar(),
        parcel.createStringArrayList()!!
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        dest!!.writeInt(huruf.toInt())
        dest.writeStringList(kata)
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
