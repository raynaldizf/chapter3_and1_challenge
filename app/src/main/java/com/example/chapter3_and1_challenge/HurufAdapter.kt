package com.example.chapter3_and1_challenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView


class HurufAdapter(val listHuruf : ArrayList<Huruf>) : RecyclerView.Adapter<HurufAdapter.ViewHolder>(){
    var onClick : ((Huruf) -> Unit)? = null

    // mengambil id dari layout
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var huruf = view.findViewById<TextView>(R.id.txtHuruf)
        var card = view.findViewById<CardView>(R.id.card)
    }

    // buat object viewholder - untuk register  view -inflate layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_kata,parent,false)
        return ViewHolder(view)
    }

    // untuk set data ke layoutnya
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.huruf.text = listHuruf[position].huruf.toString()
        holder.card.setOnClickListener{
            onClick?.invoke(listHuruf[position])
        }
    }

    // memunculkan beberapa item pada recycleview
    override fun getItemCount(): Int {
        return listHuruf.size
    }

}