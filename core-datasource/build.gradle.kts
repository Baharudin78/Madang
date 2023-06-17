import com.baharudin.buildsrc.Configuration
import com.baharudin.buildsrc.Depedencies

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.baharudin.datasource"
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
    implementation(project(":core-network"))
    implementation(project(":core-cache"))

    implementation(Depedencies.AndroidX.Core.coreKtx)
    implementation(Depedencies.AndroidX.AppCompat.appcompat)

    //data store
    implementation(Depedencies.AndroidX.DataStore.preferences)

    // Dagger hilt
    with(Depedencies.Google.DaggerHilt){
        implementation(android)
        implementation(compiler)
    }
    kapt(Depedencies.AndroidX.Hilt.compiler)
    kapt(Depedencies.Google.DaggerHilt.compiler)

    //Firebase
    with(Depedencies.Google.Firebase) {
        implementation(platform(bom))
        implementation(authKtx)
        implementation(fireStoreKtx)
        implementation(storage)
    }
    //Play Services
    implementation(Depedencies.Org.Jetbrains.Kotlinx.coroutinePlayServices)
    //Play Services Auth
    implementation(Depedencies.Google.AndroidGms.playServicesAuth)


    // Coroutines
    with(Depedencies.Org.Jetbrains.Kotlinx) {
        implementation(coroutineCore)
        implementation(coroutineAndroid)
        implementation(coroutinePlayServices)
    }

    //Work Manger
    implementation(Depedencies.AndroidX.Work.runtime)

    //coil
    implementation(Depedencies.IO.Coil.compose)

    //Local unit tests
    testImplementation(Depedencies.AndroidX.Test.core)
    testImplementation(Depedencies.Junit.junit4)
    testImplementation(Depedencies.AndroidX.Arch.coreTest)
    testImplementation(Depedencies.Org.Jetbrains.Kotlinx.coroutineTest)
    testImplementation(Depedencies.Google.Truth.truth)
    testImplementation(Depedencies.SquareUp.Okhhtp3.mockwebserver)

    testImplementation(Depedencies.IO.Mockk.mockk)
}