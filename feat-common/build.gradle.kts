import com.baharudin.buildsrc.Depedencies
import com.baharudin.buildsrc.Configuration

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.baharudin.common"
    compileSdk = Configuration.compileSdk

    defaultConfig {
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = com.baharudin.buildsrc.Version.compose_version
    }

}

dependencies {

    implementation(project(":core"))
    implementation(project(":core-domain"))

    with(Depedencies.AndroidX.Compose) {
        implementation(ui)
        implementation(material)
        implementation(toolingPreview)
        implementation(materialIconsExtended)
        implementation(runtime)
    }

    //implementation androidx.activity:activity-compose:1.7.0
    implementation(Depedencies.AndroidX.Core.coreKtx)


    // Compose dependencies
    implementation(Depedencies.Google.Accompanist.flowLayout)
    implementation(Depedencies.AndroidX.Navigation.compose)
    //implementation "androidx.constraintlayout:constraintlayout-compose:1.0.1"

    // Coroutine Lifecycle Scopes
    with(Depedencies.AndroidX.Lifecycle) {
        implementation(viewModelKtx)
        implementation(runtimeKtx)
        implementation(viewModelCompose)
    }


    //lottie
    implementation(Depedencies.Airbnb.Android.lottieCompose)
}