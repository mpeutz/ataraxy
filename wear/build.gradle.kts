plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.ataraxy.wear"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ataraxy.wear"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
            isShrinkResources = true
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

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Shared domain models
    implementation(project(":core:domain"))

    // Wearable Data Layer
    implementation(libs.play.services.wearable)
    implementation(libs.kotlinx.coroutines.play.services)
    implementation(libs.kotlinx.coroutines.guava)

    // Wear Compose
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.wear.compose.material3)
    implementation(libs.androidx.wear.compose.navigation)
    implementation(libs.androidx.wear.compose.foundation)
    implementation(libs.androidx.ui.tooling.preview)
    debugImplementation(libs.androidx.ui.tooling)

    // Wear Tiles & ProtoLayout
    implementation(libs.androidx.wear.tiles)
    implementation(libs.androidx.wear.protolayout)
    implementation(libs.androidx.wear.protolayout.material)

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    ksp(libs.hilt.compiler)

    // Hilt Navigation Compose (for hiltViewModel() in Composables)
    implementation(libs.hilt.navigation.compose)

    // DataStore
    implementation(libs.androidx.datastore.preferences)

    // Core / Lifecycle
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
}
