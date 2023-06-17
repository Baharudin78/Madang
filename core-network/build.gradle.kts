import com.baharudin.buildsrc.Configuration
import com.baharudin.buildsrc.Depedencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.baharudin.core"
    compileSdk = Configuration.compileSdk

    defaultConfig {
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            getByName("release") {
                isMinifyEnabled = false
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(project(":core"))
    implementation(project(":core-domain"))

    implementation(Depedencies.AndroidX.Core.coreKtx)
    implementation(Depedencies.AndroidX.AppCompat.appcompat)
    implementation(Depedencies.Google.AndroidMaterial.material)
    testImplementation(Depedencies.Junit.junit4)

    //retrofit
    implementation(Depedencies.SquareUp.Retrofit2.retrofit)
    implementation(Depedencies.SquareUp.Retrofit2.convertorGson)
    implementation(Depedencies.SquareUp.Okhhtp3.okhttp)

    // Dagger hilt
    implementation(Depedencies.Google.DaggerHilt.android)
    kapt(Depedencies.Google.DaggerHilt.compiler)
    kapt(Depedencies.AndroidX.Hilt.compiler)
}