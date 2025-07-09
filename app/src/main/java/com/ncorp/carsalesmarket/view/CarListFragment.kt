package com.ncorp.carsalesmarket.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ncorp.carsalesmarket.adapter.Adapter
import com.ncorp.carsalesmarket.databinding.FragmentCarListBinding
import com.ncorp.carsalesmarket.model.AccidentStatus
import com.ncorp.carsalesmarket.model.BodyType
import com.ncorp.carsalesmarket.model.Cars
import com.ncorp.carsalesmarket.model.Color
import com.ncorp.carsalesmarket.model.Condition
import com.ncorp.carsalesmarket.model.FuelType
import com.ncorp.carsalesmarket.model.Transmission


class CarListFragment : Fragment() {
	private lateinit var carList: ArrayList<Cars>
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
		return view
	}


	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		var cars = Cars(
			brand = "Ford",
			model = "Focus",
			year = 2018,
			fuelType = FuelType.DIESEL,
			transmission = Transmission.MANUAL,
			engineCapacity = 2.0,
			enginePower = 150,
			color = Color.BLUE,
			bodyType = BodyType.HATCHBACK,
			condition = Condition.USED,
			accidentStatus = AccidentStatus.MINOR_ACCIDENT,
			mileage = 60000,
			price = 180000.0,
			city = "Ankara",
			phoneNumber = "+905551114455",
			imageUri = null,
			extraNotes = "Ufak boya var."
		)
		carList = arrayListOf<Cars>()
		for (i in 1..10) {
			carList.add(cars)
		}


		val adapter = Adapter(carList)
		binding.recyclerCarView.layoutManager = LinearLayoutManager(requireContext())
		binding.recyclerCarView.adapter = adapter


	}


	override fun onDestroy() {
		super.onDestroy()
		_binding = null
	}
}


