package com.clase.foodapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.clase.foodapp.R
import com.clase.foodapp.databinding.FragmentDashboardBinding
import com.clase.foodapp.recyclers.AdapterRestaurante
import com.clase.foodapp.recyclers.Restaurante

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        ////////////////////////////////////

        val recyclerView: RecyclerView = root.findViewById(R.id.recyclerviewRestaurante)
        recyclerView.layoutManager = GridLayoutManager(this.context, 2)

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
        restaurantes.add(Restaurante("Chester", "Pastas"))
        restaurantes.add(Restaurante("Chester", "Pastas"))

        val adapter = AdapterRestaurante(restaurantes)
        recyclerView.adapter = adapter


        dashboardViewModel.text.observe(viewLifecycleOwner) {
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}