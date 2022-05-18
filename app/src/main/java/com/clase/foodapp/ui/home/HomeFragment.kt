package com.clase.foodapp.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.clase.foodapp.Carrito
import com.clase.foodapp.R
import com.clase.foodapp.databinding.FragmentHomeBinding
import com.clase.foodapp.recyclers.AdapterRestaurante
import com.clase.foodapp.recyclers.Restaurante
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("WrongConstant")
    override fun onCreateView(
        ///////////////////////////////////////////////////// CODIGO FRAGMENT
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.text.observe(viewLifecycleOwner) {
        }
        //////////////////////////////////////////////////// RECYCLER VIEW

        val recyclerView: RecyclerView = root.findViewById(R.id.recyclerviewRestaurante)
        recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayout.VERTICAL, false)

        val restaurantes = ArrayList<Restaurante>()
        restaurantes.add(Restaurante("BurgerKing", "Hamburguesas"))
        restaurantes.add(Restaurante("Chester", "Pastas"))
        restaurantes.add(Restaurante("Chester", "Pastas"))
        restaurantes.add(Restaurante("Chester", "Pastas"))
        restaurantes.add(Restaurante("Chester", "Pastas"))
        restaurantes.add(Restaurante("Chester", "Pastas"))
        restaurantes.add(Restaurante("Chester", "Pastas"))
        restaurantes.add(Restaurante("Chester", "Pastas"))
        restaurantes.add(Restaurante("Chester", "Pastas"))
        restaurantes.add(Restaurante("Chester", "Pastas"))


        val adapter = AdapterRestaurante(restaurantes)
        recyclerView.adapter = adapter

        return root
    }

    ////////////////////////////////////////////////////// MOVIMIENTO ENTRE ACTIVITIES
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        carritoHome.setOnClickListener {
            activity?.let {
                val intent = Intent(it, Carrito::class.java)
                it.startActivity(intent)
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}