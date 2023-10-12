package com.example.chapter3_and1_challenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import binar.academy.challenge_chapter3_intent.adapter.KataAdapter
import com.example.chapter3_and1_challenge.databinding.FragmentKataBinding

class KataFragment : Fragment() {
    lateinit var binding : FragmentKataBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentKataBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val getData = this.arguments?.getParcelable<Huruf>("datahuruf") as Huruf
        binding.headerTittleKata.text = "Words That Start With ${getData.huruf}"

        var adapterKata = getData.kata?.let { KataAdapter(it) }
        val lm = GridLayoutManager(context, 1)

        binding.rvKata.adapter = adapterKata
        binding.rvKata.layoutManager = lm

        binding.btnArrowBack.setOnClickListener{
            findNavController().navigateUp()
        }
    }
}