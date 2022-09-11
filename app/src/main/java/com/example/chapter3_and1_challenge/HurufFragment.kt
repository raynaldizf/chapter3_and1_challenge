package com.example.chapter3_and1_challenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_huruf.*

class HurufFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_huruf, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listHuruf = arrayListOf(
            Huruf('A', arrayListOf("Ayam", "Anak", "Anoa")),
            Huruf('B', arrayListOf("Baju", "Bajai", "Badak")),
            Huruf('C', arrayListOf("Cicak", "Cuka", "Celana")),
            Huruf('D', arrayListOf("Dewa", "Duku", "Delman")),
            Huruf('E', arrayListOf("Etiopia", "Elang", "Enak")),
            Huruf('F', arrayListOf("Faham", "Fasih", "Fuji")),
            Huruf('G', arrayListOf("Ganteng", "Gagak", "Gudeg")),
            Huruf('H', arrayListOf("Haji", "Hujan", "Halaman")),
            Huruf('I', arrayListOf("Ikan", "Itik", "Iguana")),
            Huruf('J', arrayListOf("Jerapah", "Jumbo", "Julid"))
        )

        var adapterHuruf = HurufAdapter(listHuruf)
        val lm = GridLayoutManager(context, 1)

        rvHuruf.layoutManager = lm
        rvHuruf.adapter = adapterHuruf

        adapterHuruf.onClick = {
            val bundle = Bundle()
            bundle.putParcelable("datahuruf", it)

            val fragment = KataFragment()
            fragment.arguments = bundle

            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fcHuruf, fragment)
                .commit()
            }
        }
    }
}