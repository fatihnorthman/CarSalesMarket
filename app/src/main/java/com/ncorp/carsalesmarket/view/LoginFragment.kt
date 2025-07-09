package com.ncorp.carsalesmarket.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.ncorp.carsalesmarket.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
	private var _binding: FragmentLoginBinding? = null
	private val binding get() = _binding!!


	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

	}

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		// Inflate the layout for this fragment
		_binding = FragmentLoginBinding.inflate(inflater, container, false)
		val view = binding.root
		return view
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		binding.loginButton.setOnClickListener {
			val action = LoginFragmentDirections.actionLoginFragmentToCarListFragment()
			findNavController().navigate(action)
		}
	}

	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}


}