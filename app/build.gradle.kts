plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.editkaro"
    compileSdk = 34
    buildFeatures{
        viewBinding=true
    }

    defaultConfig {

        applicationId = "com.example.editkaro"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}


dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)

    implementation("com.github.dhaval2404:imagepicker:2.1") {
        exclude(group = "androidx.core", module = "core")
        exclude(group = "com.android.support", module = "support-compat")
    }

    implementation("com.github.bumptech.glide:glide:4.16.0") {
        exclude(group = "androidx.core", module = "core")
        exclude(group = "com.android.support", module = "support-compat")
    }
    annotationProcessor("com.github.bumptech.glide:compiler:4.16.0")

    implementation("com.github.mukeshsolanki:photofilter:1.0.2") {
        exclude(group = "androidx.core", module = "core")
        exclude(group = "com.android.support", module = "support-compat")
    }

    implementation("com.github.zomato:androidphotofilters:1.0.2") {
        exclude(group = "androidx.core", module = "core")
        exclude(group = "com.android.support", module = "support-compat")
    }

    implementation("com.github.mukeshsolanki:photofilter:1.0.2") {
        exclude(group = "androidx.core", module = "core")
        exclude(group = "com.android.support", module = "support-compat")
    }

    configurations.all {
        resolutionStrategy {
            force("androidx.core:core:1.13.1") // Adjust the version as needed
        }
    }

}
