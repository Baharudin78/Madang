import com.baharudin.buildsrc.Configuration
import com.baharudin.buildsrc.Depedencies
import com.baharudin.buildsrc.Version

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.baharudin.madang"
    compileSdk = Configuration.compileSdk

    defaultConfig {
        applicationId = Configuration.applicationId
        minSdk = Configuration.minSdk
        targetSdk = Configuration.targetSdk
        versionCode = Configuration.versionCode
        versionName = Configuration.versionName

        testInstrumentationRunner =  "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }

        debug {
            isDebuggable = true
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
        kotlinCompilerExtensionVersion = Version.compose_version
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
}

dependencies {

    implementation(project(":core"))
    implementation(project(":core-domain"))
    implementation(project(":core-datasource"))
    implementation(project(":core-infrastructure"))
    implementation(project(":feat-common"))
//    implementation(project(":feat-coin-detail"))
//    implementation(project(":feat-coins"))
//    implementation(project(":feat-favorite-coins"))
//    implementation(project(":feat-news"))
//    implementation(project(":feat-profile"))
//    implementation(project(":feat-onboarding"))
//    implementation(project(":feat-auth-signin"))
//    implementation(project(":feat-auth-signup"))
//    implementation(project(":feat-auth-forgot-password"))

    with(Depedencies.AndroidX.Core){
        implementation(coreKtx)
        implementation(splashScreen)
    }
    with(Depedencies.AndroidX.Compose) {
        implementation(ui)
        implementation(material)
        implementation(toolingPreview)
        implementation(materialIconsExtended)
        implementation(runtime)
    }
    // Coroutine Lifecycle Scopes
    with(Depedencies.AndroidX.Lifecycle) {
        implementation(viewModelKtx)
        implementation(runtimeKtx)
        implementation(viewModelCompose)
        implementation(runtime)
    }
    implementation(Depedencies.AndroidX.Activity.compose)

    // Compose dependencies
    implementation(Depedencies.AndroidX.Navigation.compose)
    implementation(Depedencies.AndroidX.ConstraintLayout.compose)

    // Accompanist insets UI
    with(Depedencies.Google.Accompanist) {
        implementation(insetsUi)
        implementation(flowLayout)
        implementation(navigationAnimation)
    }

    // Coroutines
    with(Depedencies.Org.Jetbrains.Kotlinx) {
        implementation(coroutineCore)
        implementation(coroutineAndroid)
        implementation(coroutinePlayServices)
    }

    // Dagger hilt
    with(Depedencies.Google.DaggerHilt) {
        implementation(android)
        kapt(compiler)
    }

    with(Depedencies.AndroidX.Hilt) {
        implementation(navigationCompose)
        implementation(work)
        kapt(compiler)
    }
}