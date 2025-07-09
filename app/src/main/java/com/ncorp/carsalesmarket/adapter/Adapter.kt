package com.ncorp.carsalesmarket.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ncorp.carsalesmarket.databinding.RecyclerRowBinding
import com.ncorp.carsalesmarket.model.Cars

class Adapter(private val carsList: List<Cars>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

	override fun onCreateViewHolder(
		parent: ViewGroup,
		viewType: Int
	): ViewHolder {
		val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return ViewHolder(binding)
	}

	override fun onBindViewHolder(
		holder: ViewHolder,
		position: Int
	) {
		holder.bind(carsList[position])
	}

	override fun getItemCount(): Int {
		return carsList.size
	}

	class ViewHolder(var binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {
		fun bind(car: Cars) {
			TODO("XMLDEKİ IDLER DÜZELTİLECEK")
			binding.textViewModel.text = car.model
			binding.textViewYear.text = car.year.toString()
			binding.textViewMileage.text = "${car.mileage} km"
			binding.textViewPrice.text = "${car.price} ₺"
			binding.textViewCity.text = car.city
			binding.textViewPhone.text = car.phoneNumber
			binding.textViewFuelType.text = car.fuelType.name.replaceFirstChar { it.uppercase() }
			binding.textViewTransmission.text = car.transmission.name.replaceFirstChar { it.uppercase() }
			binding.textViewCondition.text = car.condition.name.replaceFirstChar { it.uppercase() }
			binding.textViewExtraNotes.text = car.extraNotes ?: ""

			// Resim varsa Glide ile yükle, yoksa placeholder göster
			if (!car.imageUri.isNullOrEmpty()) {
				Glide.with(binding.imageViewCar.context)
					.load(car.imageUri)
					.placeholder(R.drawable.placeholder_car)
					.into(binding.imageViewCar)
			} else {
				binding.imageViewCar.setImageResource(R.drawable.placeholder_car)
			}
		}
	}
}
