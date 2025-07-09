package com.ncorp.carsalesmarket.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ncorp.carsalesmarket.databinding.FragmentCarListBinding


class CarListFragment : Fragment() {
	private var _binding: FragmentCarListBinding? = null
	private val binding get() = _binding!!


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		_binding = FragmentCarListBinding.inflate(inflater, container, false)
		val view = binding.root
		return view	}


	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)




	}


	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}
	}


