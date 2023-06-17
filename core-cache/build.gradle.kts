import com.baharudin.buildsrc.Configuration
import com.baharudin.buildsrc.Depedencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
}

android {
    namespace = "com.baharudin.cache"
    compileSdk = Configuration.compileSdk

    defaultConfig {
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //consumerProguardFiles = "consumer-rules.pro"
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

    // Dagger hilt
    with(Depedencies.Google.DaggerHilt){
        implementation(android)
        kapt(compiler)
    }
    kapt(Depedencies.AndroidX.Hilt.compiler)

    //Room Database
    implementation(Depedencies.AndroidX.Room.runtime)
    annotationProcessor(Depedencies.AndroidX.Room.compiler)
    kapt(Depedencies.AndroidX.Room.compiler)
    implementation(Depedencies.AndroidX.Room.ktx)
}