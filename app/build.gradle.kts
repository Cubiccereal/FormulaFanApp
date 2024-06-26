plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
}

android {
    namespace = "com.example.formulaonefanapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.formulaonefanapp"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

        dependencies {
            implementation("com.google.code.gson:gson:2.8.8")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
            implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")
            implementation("com.squareup.retrofit2:retrofit:2.9.0")
            implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation ("com.google.android.gms:play-services-maps:18.0.2")
        implementation ("com.google.maps.android:android-maps-utils:2.3.0")
        implementation ("org.jetbrains.kotlin:kotlin-stdlib:1.8.0")
        implementation ("androidx.core:core-ktx:1.9.0")
        implementation ("androidx.appcompat:appcompat:1.5.1")
        implementation ("com.google.android.material:material:1.7.0")
        implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
        implementation ("com.squareup.okhttp3:okhttp:4.10.0")
        implementation ("com.google.code.gson:gson:2.8.9")
        testImplementation ("junit:junit:4.13.2")
        androidTestImplementation ("androidx.test.ext:junit:1.1.4")
        androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.0")
    }