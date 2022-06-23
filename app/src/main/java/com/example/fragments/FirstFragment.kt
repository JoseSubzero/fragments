package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fragments.databinding.FragmentFirstBinding
import kotlin.random.Random

class FirstFragment : Fragment() {
    private var _binding:FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val dados = arrayOf(R.drawable.dice1, //Son enteros basados en su indentificaor como si fueran un codigo de barras/etiqueta
        R.drawable.dice2,
        R.drawable.dice3,
        R.drawable.dice4,
        R.drawable.dice5,
        R.drawable.dice6)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.ivDado1.setOnClickListener {
            val d1 = Random.nextInt(1, 7)
            val d2 = Random.nextInt(1, 7)
            binding.ivDado1.setImageResource(dados[d1-1])
            binding.ivDado2.setImageResource(dados[d2-1])
            binding.tvResultado.text = (d1 + d2).toString()
        }
        binding.ivDado2.setOnClickListener {
            val d1 = Random.nextInt(1, 7)
            val d2 = Random.nextInt(1, 7)
            binding.ivDado1.setImageResource(dados[d1-1])
            binding.ivDado2.setImageResource(dados[d2-1])
            binding.tvResultado.text = (d1 + d2).toString()
        }

        FragmentFirstBinding.inflate(inflater, container, false)
        return _binding!!.root

    }
}