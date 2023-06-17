import com.baharudin.buildsrc.Depedencies
import com.baharudin.buildsrc.Configuration

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.baharudin"
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
    implementation(project(":core-datasource"))
    implementation(project(":core-domain"))

    implementation(Depedencies.AndroidX.Core.coreKtx)
    implementation(Depedencies.AndroidX.AppCompat.appcompat)

    // Dagger hilt
    with(Depedencies.Google.DaggerHilt){
        implementation(android)
        implementation(compiler)
    }
    kapt(Depedencies.AndroidX.Hilt.compiler)
    implementation(Depedencies.AndroidX.Hilt.work)


    // Coroutines
    with(Depedencies.Org.Jetbrains.Kotlinx) {
        implementation(coroutineCore)
        implementation(coroutineAndroid)
        implementation(coroutinePlayServices)
    }

    //Work Manger
    implementation(Depedencies.AndroidX.Work.runtime)
}