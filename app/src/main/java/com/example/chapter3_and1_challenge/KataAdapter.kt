package binar.academy.challenge_chapter3_intent.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter3_and1_challenge.R


class KataAdapter(private val listKata: ArrayList<String>) : RecyclerView.Adapter<KataAdapter.ViewHolder>() {

    // mengambil id dari layout
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
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
        holder.huruf.text = listKata[position]
        var kata = holder.huruf.text
        holder.card.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=${kata}"))
            it.context.startActivity(intent)
        }
    }

    // memunculkan beberapa item pada recycleview
    override fun getItemCount(): Int {
        return listKata.size
    }
}