plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kapt)

}

android {
    namespace = "com.mx.liverpool.demoitems"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mx.liverpool.demoitems"
        minSdk = 16
        targetSdk = 34
        versionCode = 1
        multiDexEnabled = true
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
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    packaging {
    }
    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.android.retofit)
    implementation(libs.json.convert)
    implementation(libs.logging.interceptor)
    implementation(libs.androidx.viewmodel)
    implementation(libs.kotlin.coroutinescore)
    implementation(libs.kotlin.coroutines)
    implementation(libs.hilt.android)
    implementation(libs.lifecycle.runtime)
    implementation(libs.bumptech.glide)
    implementation(libs.bumptech.glide.compiler)
//    implementation(libs.hilt.lifecycle)
    implementation(libs.lifecycle.viewmodl)
    implementation(libs.activity.ktx)
    implementation(libs.fragment.ktx)
//    implementation(libs.multidex)
    kapt(libs.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}