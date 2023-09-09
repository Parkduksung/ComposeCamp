import com.example.compose.configureComposeAndroid
import com.example.compose.configureCoroutineAndroid
import com.example.compose.configureKotlinAndroid

plugins {
    id("com.android.application")
}


configureKotlinAndroid()
configureComposeAndroid()
configureCoroutineAndroid()