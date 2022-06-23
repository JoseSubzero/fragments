package com.example.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.example.fragments.databinding.FragmentFirstBinding
import com.example.fragments.databinding.FragmentSecondBinding
import com.google.android.material.snackbar.Snackbar
import kotlin.random.Random


class SecondFragment : Fragment() {
    private var _binding:FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private lateinit var myView: View
    private var lista = mutableMapOf<String, String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        val btnAdd = myView.findViewById<Button>(R.id.ivDado1)

        btnAdd.setOnClickListener { addItem() }

        FragmentSecondBinding.inflate(inflater, container, false)
        return _binding!!.root
    }
    fun addItem (){
        if (binding.etArticulo.text.isNotEmpty() and binding.etPrecio.text.isNotEmpty()){
            lista.put(binding.etArticulo.text.toString(), binding.etPrecio.text.toString())
            binding.etArticulo.text.clear()
            binding.etPrecio.text.clear()
             msj(lista.toString())
        } else {
            msj("Todos los campos son obligatorios")
        }
    }
    fun msj (str:String){
        Snackbar.make(binding.root, str, Snackbar.LENGTH_LONG).show()
    }

}