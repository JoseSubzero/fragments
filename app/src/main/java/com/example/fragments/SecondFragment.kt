package com.example.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.example.fragments.databinding.FragmentFirstBinding
import com.example.fragments.databinding.FragmentSecondBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random


class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private var bundle = bundleOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAdd.setOnClickListener {
            if(binding.etArticulo.text.isNotEmpty() and binding.etPrecio.text.isNotEmpty()){
                bundle.putDouble(
                    binding.etArticulo.text.toString(),
                    binding.etPrecio.text.toString().toDouble()
                )
                binding.etArticulo.text.clear()
                binding.etPrecio.text.clear()
            } else {
                Snackbar.make(view, "Todos los campos son obligatorios", Snackbar.LENGTH_LONG)
                    .show()
            }
        }
        binding.btnEnviar.setOnClickListener {
            val datos = Bundle()
            datos.putString("ID_ARTICULO", binding.etArticulo.text.toString())
            datos.putString("ID_PRECIO", binding.etPrecio.text.toString())
            setFragmentResult("paquete1",bundle )

            val tf = ResultFragment()
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.second_frg,tf)
                .addToBackStack(null)
                .commit()
        }
    }




}