package com.clase.foodapp.ui.dashboard

import android.content.Intent
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
import com.clase.foodapp.Carrito
import com.clase.foodapp.R
import com.clase.foodapp.databinding.FragmentDashboardBinding
import com.clase.foodapp.recyclers.AdapterCategoria
import com.clase.foodapp.recyclers.AdapterRestaurante
import com.clase.foodapp.recyclers.Categoria
import com.clase.foodapp.recyclers.Restaurante
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.fragment_dashboard.*
import kotlinx.android.synthetic.main.fragment_home.*

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

        val categorias = ArrayList<Categoria>()
        val adapter = AdapterCategoria(categorias)
        val db = FirebaseFirestore.getInstance()
        db.collection("Categorias").get().addOnSuccessListener { result ->
            result.documents.forEach {
                categorias.add(Categoria(it.get("Logo").toString(), it.get("Nombre").toString()))
            }
            adapter.notifyDataSetChanged()
        }


        recyclerView.adapter = adapter


        dashboardViewModel.text.observe(viewLifecycleOwner) {
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        carritoDash.setOnClickListener {
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