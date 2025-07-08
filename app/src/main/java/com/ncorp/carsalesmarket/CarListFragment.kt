package com.ncorp.carsalesmarket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
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



		binding.menu.setOnItemSelectedListener { menuItem ->
			when (menuItem.itemId) {
				R.id.navigation_profile -> {
					val action = CarListFragmentDirections.actionCarListFragmentToProfileFragment()
					findNavController().navigate(action)
					true
				}
				R.id.navigation_search -> {
					// Arama işlemi veya fragment geçişi
					true
				}
				R.id.navigation_add -> {
					val action = CarListFragmentDirections.actionCarListFragmentToAddCarFragment()
					findNavController().navigate(action)
					true
				}
				else -> false
			}
		}
	}


	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}
	}


