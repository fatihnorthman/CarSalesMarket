package com.ncorp.carsalesmarket.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide

import androidx.recyclerview.widget.RecyclerView
import com.ncorp.carsalesmarket.R
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
		val car = carsList[position]
		with(holder.binding) {
			// Marka ve model
			textBrandModel.text = "${car.brand} ${car.model}"

			// Fiyat
			textPrice.text = "₺%,.0f".format(car.price)

			// Kilometre (örnek: 120,000 km)
			textKm.text = "%,d km".format(car.mileage)

			// Resim yükleme (örneğin Glide kullanıyorsan)
			if (car.imageUri != null) {
				Glide.with(imageCar.context)
					.load(car.imageUri)
					.centerCrop()
					.into(imageCar)
			} else {
				// Resim yoksa varsayılan veya boş bırak
				imageCar.setImageResource(R.drawable.placeholder_image)
			}
		}
	}

	override fun getItemCount(): Int {
		return carsList.size
	}

	class ViewHolder(var binding: RecyclerRowBinding) : RecyclerView.ViewHolder(binding.root) {

	}
}
