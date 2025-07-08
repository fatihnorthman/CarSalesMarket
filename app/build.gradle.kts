plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.kotlin.android)
	id("com.google.devtools.ksp")
	id("androidx.navigation.safeargs")
	id("org.jetbrains.kotlin.plugin.serialization")
}

android {
	namespace = "com.ncorp.carsalesmarket"
	compileSdk = 36

	defaultConfig {
		applicationId = "com.ncorp.carsalesmarket"
		minSdk = 27
		targetSdk = 36
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}
	buildFeatures { viewBinding = true }

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_11
		targetCompatibility = JavaVersion.VERSION_11
	}
	kotlinOptions {
		jvmTarget = "11"
	}
}

dependencies {
	implementation("com.google.android.material:material:1.12.0")
	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	implementation(libs.androidx.activity)
	implementation(libs.androidx.constraintlayout)
	implementation(libs.androidx.fragment)
	implementation(libs.androidx.recyclerview)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)


	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

	val nav_version = "2.9.1"

	// Jetpack Compose integration
	implementation("androidx.navigation:navigation-compose:$nav_version")

	// Views/Fragments integration
	implementation("androidx.navigation:navigation-fragment:$nav_version")
	implementation("androidx.navigation:navigation-ui:$nav_version")


	val room_version = "2.7.2"

	implementation("androidx.room:room-runtime:$room_version")

	// If this project uses any Kotlin source, use Kotlin Symbol Processing (KSP)
	// See Add the KSP plugin to your project

	ksp("androidx.room:room-compiler:$room_version")

	// If this project only uses Java source, use the Java annotationProcessor
	// No additional plugins are necessary
	annotationProcessor("androidx.room:room-compiler:$room_version")
	implementation("androidx.room:room-ktx:${room_version}")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.2")
}