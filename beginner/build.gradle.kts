plugins {
    id("studycompose.android.application")
}

android {
    namespace = "com.example.beginner"

    defaultConfig {
        applicationId = "com.example.beginner"
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}