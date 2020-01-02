object ApplicationId {
    val id = "com.ganesh.bitcoinapp"
}

object Modules {
    val domain = ":domain"
}

object Releases {
    val versionCode = 1
    val versionName = "1.0"
}

object Versions {
    val kotlin = "1.3.21"
    val appCompat = "1.1.0-alpha04"
    val coreKtx = "1.1.0-alpha04"
    val constraintLayout = "1.1.3"
    val retrofit = "2.5.0"
    val retrofitCoroutines = "0.9.2"
    val retrofitGson = "2.4.0"
    val gson = "2.8.5"
    val okHttp = "3.12.1"
    val coroutines = "1.3.3"
    val koin = "1.0.2"
    val nav = "2.0.0"
    var legacy = "1.0.0"
    val room = "2.1.0-alpha06"
    val safeArgs = "2.1.0-alpha01"
    val archCoreTest = "2.0.0"
    val androidJunit = "1.1.0"
    val material = "1.2.0-alpha02"
    val viewModelLifeCycle = "2.1.0-beta01"

}

object Libraries {
    // KOIN
    val koin = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    val roomRunTime = "androidx.room:room-runtime:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"

    val roomRx = "android.arch.persistence.room:rxjava2"
    // RETROFIT
    val retrofitCoroutineAdapter =
        "com.jakewharton.retrofit:retrofit2-kotlin-coroutines-adapter:${Versions.retrofitCoroutines}"
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

}

object KotlinLibraries {

    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    val kotlinCoroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
}

object AndroidLibraries {
    // ANDROID
    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val navigation = "androidx.navigation:navigation-ui-ktx:${Versions.nav}"
    val navigationFrag = "androidx.navigation:navigation-fragment-ktx:${Versions.nav}"
    val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacy}"
    val material = "com.google.android.material:material:${Versions.material}"
    val viewModelLifeCycle =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.viewModelLifeCycle}"

}

object TestLibraries {
    val archCoreTest = "androidx.arch.core:core-testing:${Versions.archCoreTest}"
    val junit = "androidx.test.ext:junit:${Versions.androidJunit}"
    val mock_kotlin = "com.nhaarman:mockito-kotlin:1.5.0"
    val mock_core = "org.mockito:mockito-core:2.16.0"
    // COROUTINE
    val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
}