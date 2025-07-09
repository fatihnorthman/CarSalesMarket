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
			// Seçilen item'ın view'ını alıyoruz (null kontrolüyle)
			val itemView = binding.navigationRail.findViewById<View>(menuItem.itemId)
			if (itemView != null) {
				itemView.animate()
					.scaleX(1.2f)
					.scaleY(1.2f)
					.setDuration(150)
					.withEndAction {
						itemView.animate()
							.scaleX(1f)
							.scaleY(1f)
							.setDuration(150)
							.start()
					}
					.start()
			}

			when (menuItem.itemId) {
				R.id.navigation_profile -> {
					navController.navigate(R.id.profileFragment)
					true
				}
				R.id.navigation_search -> {
					// Örneğin SearchFragment varsa şunu kullan:
					// navController.navigate(R.id.searchFragment)
					true
				}
				R.id.navigation_add -> {
					navController.navigate(R.id.addCarFragment)
					true
				}
				R.id.navigation_favorites -> {

					true
				}
				R.id.navigation_notifications -> {

					true
				}
				R.id.navigation_settings -> {

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