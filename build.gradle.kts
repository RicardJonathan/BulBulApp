buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.google.gms:google-services:4.3.15")
        classpath ("com.android.tools.build:gradle:8.5.0")
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id ("com.android.application") version "8.5.0" apply false
    id ("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id ("com.google.gms.google-services") version "4.3.15"
}
