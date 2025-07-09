package com.ncorp.carsalesmarket.model

import android.net.Uri
import kotlinx.serialization.Serializable

@Serializable
data class Cars(
	val brand: String,
	val model: String,
	val year: Int,
	val fuelType: FuelType,
	val transmission: Transmission,
	val engineCapacity: Double,  // örn: 1.6
	val enginePower: Int,        // örn: 120 hp
	val color: Color,
	val bodyType: BodyType,
	val condition: Condition,
	val accidentStatus: AccidentStatus,
	val mileage: Int,
	val price: Double,
	val city: String,
	val phoneNumber: String,
	val imageUri: String? = null,   // Resim URI string olarak
	val extraNotes: String? = null
)

@Serializable
enum class FuelType {
	GASOLINE, DIESEL, ELECTRIC, HYBRID, LPG
}

@Serializable
enum class Transmission {
	MANUAL, AUTOMATIC
}

@Serializable
enum class Color {
	BLACK, WHITE, RED, BLUE, SILVER, GRAY, OTHER
}

@Serializable
enum class BodyType {
	SEDAN, HATCHBACK, SUV, COUPE, CONVERTIBLE, WAGON, PICKUP, VAN, OTHER
}

@Serializable
enum class Condition {
	NEW, USED
}

@Serializable
enum class AccidentStatus {
	NO_ACCIDENT, MINOR_ACCIDENT, MAJOR_ACCIDENT
}
