plugins {
    id("studycompose.android.application")
}

android {
    namespace = "com.example.composebook1"

    defaultConfig {
        applicationId = "com.example.composebook1"
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}