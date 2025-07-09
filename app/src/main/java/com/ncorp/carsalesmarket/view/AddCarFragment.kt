package com.ncorp.carsalesmarket.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ncorp.carsalesmarket.databinding.FragmentAddCarBinding

class AddCarFragment : Fragment() {
	private var _binding: FragmentAddCarBinding? = null
	private val binding get() = _binding!!


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		_binding = FragmentAddCarBinding.inflate(inflater, container, false)
		val view = binding.root
		return view	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
	}




	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}


}