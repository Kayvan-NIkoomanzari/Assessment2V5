plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-parcelize")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("dagger.hilt.android.plugin")
}


android {
    namespace = "com.example.assessment2v5"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.assessment2v5"
        minSdk = 24
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

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.0")
    implementation ("androidx.fragment:fragment-ktx:1.6.0")
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.0")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.0")

    // implementation(libs.androidx.navigation.fragment)

    // Retrofit dependancies
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.11.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")

    // Hilt dependancies
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-android-compiler:2.51.1")
    //implementation ("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")
    //kapt ("androidx.hilt:hilt-compiler:1.0.0")
    //implementation ("androidx.hilt:hilt-navigation-fragment:1.0.0")
    // Testing dependancies
    testImplementation("io.mockk:mockk:1.13.12")
    testImplementation("io.mockk:mockk-android:1.13.12")
    testImplementation("io.mockk:mockk-agent:1.13.12")
    testImplementation(libs.junit)
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1")

    androidTestImplementation("io.mockk:mockk-android:1.13.12")
    androidTestImplementation("io.mockk:mockk-agent:1.13.12")
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}