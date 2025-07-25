// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
	alias(libs.plugins.android.application) apply false
	alias(libs.plugins.kotlin.android) apply false
	id("androidx.navigation.safeargs") version "2.9.0" apply false
	id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
	id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0" apply false
}