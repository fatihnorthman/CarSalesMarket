package com.ncorp.carsalesmarket.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import com.ncorp.carsalesmarket.R
import android.view.ViewGroup
import android.widget.ArrayAdapter
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
		_binding = FragmentAddCarBinding.inflate(inflater, container, false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		val context = requireContext()

		val yearAdapter = ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.years_array))
		val fuelAdapter = ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.fuel_types_array))
		val gearboxAdapter = ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.gearbox_array))
		val colorAdapter = ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.colors_array))
		val bodyTypeAdapter = ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.body_types_array))
		val conditionAdapter = ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.condition_array))
		val accidentAdapter = ArrayAdapter(context, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.accident_array))

		binding.autoCompleteYear.setAdapter(yearAdapter)
		binding.autoCompleteFuelType.setAdapter(fuelAdapter)
		binding.autoCompleteGearbox.setAdapter(gearboxAdapter)
		binding.autoCompleteColor.setAdapter(colorAdapter)
		binding.autoCompleteBodyType.setAdapter(bodyTypeAdapter)
		binding.autoCompleteCondition.setAdapter(conditionAdapter)
		binding.autoCompleteAccident.setAdapter(accidentAdapter)

		// Zorunlu değil ama dropdown'u tetiklemek için faydalı
		binding.autoCompleteYear.setOnClickListener { binding.autoCompleteYear.showDropDown() }
		binding.autoCompleteFuelType.setOnClickListener { binding.autoCompleteFuelType.showDropDown() }
		binding.autoCompleteGearbox.setOnClickListener { binding.autoCompleteGearbox.showDropDown() }
		binding.autoCompleteColor.setOnClickListener { binding.autoCompleteColor.showDropDown() }
		binding.autoCompleteBodyType.setOnClickListener { binding.autoCompleteBodyType.showDropDown() }
		binding.autoCompleteCondition.setOnClickListener { binding.autoCompleteCondition.showDropDown() }
		binding.autoCompleteAccident.setOnClickListener { binding.autoCompleteAccident.showDropDown() }
	}


	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}
}
