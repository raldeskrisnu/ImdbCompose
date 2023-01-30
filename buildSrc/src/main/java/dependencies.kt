object Dependencies {
    const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlin_coroutines}"
    const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlin_coroutines}"

    const val hilt = "com.google.dagger:hilt-android:${Versions.di_hilt}"
    const val hiltCompiler =  "com.google.dagger:hilt-compiler:${Versions.di_hilt}"

    const val room = "androidx.room:room-runtime:${Versions.room}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"

    const val androidX = "androidx.core:core-ktx:${Versions.androidx_core}"
    const val androidActivity = "androidx.activity:activity-ktx:${Versions.androidx_activity}"
    const val androidAnnottaion = "androidx.annotation:annotation:${Versions.annotations}"
    const val androidAppCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycle}"

    const val compose = "androidx.compose.ui:ui:${Versions.compose_core}"
    const val composeTooling = "androidx.compose.ui:ui-tooling:${Versions.compose_core}"
    const val composeToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.compose_core}"
    const val materialCompose = "androidx.compose.material:material:${Versions.compose_core}"
    const val materialComposeIcon = "androidx.compose.material:material-icons-core:${Versions.compose_core}"
    const val materialExtended =  "androidx.compose.material:material-icons-extended:${Versions.compose_core}"
    const val liveData = "androidx.compose.runtime:runtime-livedata:${Versions.compose_core}"
    const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.compose_view_model}"
    const val activityCompose = "androidx.activity:activity-compose:${Versions.compose_activity}"
    const val navigationCompose = "androidx.navigation:navigation-compose:${Versions.compose_navigation}"
    const val navigationHiltCompose =  "androidx.hilt:hilt-navigation-compose:${Versions.compose_hilt_navigation}"
    const val pagingCompose = "androidx.paging:paging-compose:${Versions.compose_paging}"
    const val coil = "io.coil-kt:coil-compose:${Versions.compose_coil}"

    const val materialGoogle = "com.google.android.material:material:${Versions.material}"
    const val flowlayout = "com.google.accompanist:accompanist-flowlayout:${Versions.accompanist}"
    const val insets =  "com.google.accompanist:accompanist-insets:${Versions.accompanist}"
    const val systemuicontroller = "com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    const val logging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp_logging}"

    const val threeten = "com.jakewharton.threetenabp:threetenabp:${Versions.three_ten_bp}"
    const val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    const val roomTesting = "androidx.room:room-testing:${Versions.room}"
    const val hiltAndroidTesting = "com.google.dagger:hilt-android-testing:${Versions.di_hilt}"
    const val hiltCompilerTest =  "com.google.dagger:hilt-compiler:${Versions.di_hilt}"
    const val daggerHiltTest = "com.google.dagger:hilt-android-testing:${Versions.di_hilt}"
    const val daggerHiltCompilerTest = "com.google.dagger:hilt-compiler:${Versions.di_hilt}"



    const val javaInject = "javax.inject:javax.inject:${Versions.jvm_inject}"

}

object Versions {

    const val kotlin_lang = "1.7.10"
    const val kotlin_coroutines = "1.6.2"

    const val di_hilt = "2.44"

    const val jvm_inject = "1"

    const val compose_compiler = "1.3.0"
    const val compose_core = "1.2.1"
    const val compose_activity = "1.5.1"
    const val compose_navigation = "2.5.1"
    const val compose_hilt_navigation = "1.0.0"
    const val compose_view_model = "2.4.0"
    const val compose_paging = "1.0.0-alpha14"
    const val compose_coil = "2.2.0"

    const val room = "2.4.3"
    const val androidx_core = "1.8.0"
    const val androidx_activity = "1.5.1"
    const val annotations = "1.4.0"
    const val appcompat = "1.5.0"
    const val lifecycle = "2.5.1"
    const val material = "1.6.1"
    const val accompanist = "0.21.1-beta"
    const val retrofit = "2.9.0"
    const val okhttp_logging = "4.9.1"
    const val three_ten_bp = "1.3.1"
    const val timber = "5.0.1"
}

object test {
    const val arch_core = "2.1.0"
    const val androidx_core = "1.4.0"
    const val junit_ext = "1.1.3"
    const val runner = "1.4.0"
    const val rules = "1.4.0"
    const val truth_ext = "1.4.0"
    const val espresso = "3.4.0"
    const val hamcrest = "2.2"
    const val junit = "4.13.2"
    const val mockito = "2.25.0"
    const val mock_web_server = "4.4.0"
}