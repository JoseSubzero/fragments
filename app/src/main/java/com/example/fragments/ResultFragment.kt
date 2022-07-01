package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.example.fragments.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("paquete1"){paquete, datos ->
            val claves =  datos.keySet()
            var total = 0.0
            var lista = "LISTA\n\n"
            for (clave in claves) {
                lista += clave + "\t" + datos.getDouble(clave) + "\n"
                total += datos.getDouble(clave)
            }
            lista += "\n\nTOTAL: $total €"
            binding.tvTotal.text = lista
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

}