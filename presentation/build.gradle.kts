plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.tmo"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.tmo"
        minSdk = 24
        targetSdk = 33
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
    implementation(project(":domain"))
    implementation(project(":di"))

    //hilt
    implementation(Dependency.Google.HILT_ANDROID)
    kapt(Dependency.Google.HILT_ANDROID_COMPILER)

    //androidx
    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.APP_COMPAT)
    implementation(Dependency.AndroidX.MATERIAL)
    implementation(Dependency.AndroidX.CONSTRAINT_LAYOUT)

    //unitTest
    testImplementation(Dependency.UnitTest.JUNIT)

    //androidTest
    androidTestImplementation(Dependency.AndroidTest.ANDROID_JUNIT)
    androidTestImplementation(Dependency.AndroidTest.ESPRESSO_CORE)

    //lifecycle
    implementation(Dependency.AndroidX.LIFECYCLE_VIEWMODEL_KTX)
    implementation(Dependency.AndroidX.LIFECYCLE_RUNTIME)
    implementation(Dependency.AndroidX.LIFECYCLE_LIVEDATA_KTX)

    implementation(Dependency.AndroidX.ACTIVITY_KTX)

}