plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 26
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
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    // Retrofit for network operations
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    // Gson Converter for Retrofit
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp logging interceptor
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.3")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")
    implementation("com.google.code.gson:gson:2.11.0")

    // Retrofit Mock
    testImplementation ("com.squareup.retrofit2:retrofit-mock:2.9.0")

    // Unit testing dependencies
    testImplementation("junit:junit:4.13.2")
    testImplementation ("org.mockito:mockito-core:3.9.0")
    testImplementation ("androidx.arch.core:core-testing:2.2.0")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.5.2")
    androidTestImplementation("junit:junit:4.12")
}