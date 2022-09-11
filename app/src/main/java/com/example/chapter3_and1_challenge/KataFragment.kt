package com.example.chapter3_and1_challenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import binar.academy.challenge_chapter3_intent.adapter.KataAdapter
import kotlinx.android.synthetic.main.fragment_kata.*

class KataFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kata, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val getData = this.arguments?.getParcelable<Huruf>("datahuruf") as Huruf
        headerTittleKata.text = "Words That Start With ${getData.huruf}"

        var adapterKata = getData.kata?.let { KataAdapter(it) }
        val lm = GridLayoutManager(context, 1)

        rvKata.adapter = adapterKata
        rvKata.layoutManager = lm

        btnArrowBack.setOnClickListener{
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fcHuruf, HurufFragment())
                commit()
            }
        }
    }
}