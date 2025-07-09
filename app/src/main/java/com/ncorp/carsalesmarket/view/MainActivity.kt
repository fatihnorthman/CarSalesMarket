package com.ncorp.carsalesmarket.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.ncorp.carsalesmarket.R
import com.ncorp.carsalesmarket.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	private lateinit var binding: ActivityMainBinding
	private lateinit var navController: NavController

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		// NavController'ı FragmentContainerView üzerinden al
		val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
		navController = navHostFragment.navController

		// NavigationRail item seçimine listener ekle
		binding.navigationRail.setOnItemSelectedListener { menuItem ->
			when (menuItem.itemId) {
				R.id.navigation_profile -> {
					navController.navigate(R.id.profileFragment)
					true
				}
				R.id.navigation_search -> {
					// Örneğin search fragment yoksa TODO bırakabiliriz
					// navController.navigate(R.id.searchFragment)
					true
				}
				R.id.navigation_add -> {
					navController.navigate(R.id.addCarFragment)
					true
				}
				else -> false
			}
		}

		// Fragment değiştikçe NavigationRail görünürlüğünü veya diğer UI kontrollerini ayarlayabilirsin
		navController.addOnDestinationChangedListener { _, destination, _ ->
			// Örneğin loginFragment'teyken navigationRail gizle
			binding.navigationRail.visibility = if (destination.id == R.id.loginFragment) View.GONE else View.VISIBLE
		}
	}
}