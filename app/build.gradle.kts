plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

}

android {
    namespace = "com.example.bulbulapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.bulbulapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.compose.material3:material3:1.2.1")
    implementation("androidx.compose.material3:material3-window-size-class:1.2.1")
    implementation("androidx.compose.material3:material3-adaptive-navigation-suite:1.3.0-beta01")
    implementation("androidx.compose.ui:ui:1.6.7") // Sesuaikan dengan versi bom Compose
    implementation("androidx.compose.foundation:foundation:1.6.7") // Sesuaikan dengan versi bom Compose
    implementation("com.airbnb.android:lottie-compose:5.2.0")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.compose.ui:ui-tooling-preview:1.6.7") // Sesuaikan dengan versi bom Compose
    implementation("androidx.compose.material3:material3:1.2.1") // Sesuaikan dengan versi bom Compose
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.6.7") // Sesuaikan dengan versi bom Compose
    debugImplementation("androidx.compose.ui:ui-tooling:1.6.7") // Sesuaikan dengan versi bom Compose
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.6.7") // Sesuaikan dengan versi bom Compose
}
