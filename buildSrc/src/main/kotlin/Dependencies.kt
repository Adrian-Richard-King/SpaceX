const val kotlinVersion = "1.3.50"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.5.2"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"

}

object AndroidSdk {
    const val min = 21
    const val compile = 29
    const val target = compile
}

object Libraries {
    private object Versions {
        const val constraintLayout = "1.1.3"
        const val recyclerView = "1.0.0"
        const val materialDesign = "1.0.0"
        const val appcompat = "1.1.0"
        const val androidAnnotation = "1.1.0"
        const val rxjava2 = "2.2.6"
        const val rxAndroid = "2.1.1"
        const val gson = "2.8.5"
        const val retrofit = "2.4.0"
        const val retrofitGson = "2.4.0"
        const val retrofitRxJava2 = "2.4.0"
        const val lifecycle = "2.1.0"
        const val glide = "4.9.0"
        const val circularImage = "3.2.0"
        const val okhttpLogging = "3.13.1"

        const val ktx = "1.1.0-alpha05"
    }

    const val appCompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerView}"
    const val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    const val androidAnnotation = "androidx.annotation:annotation:${Versions.androidAnnotation}"

    const val rxJava2Runtime = "io.reactivex.rxjava2:rxjava:${Versions.rxjava2}"
    const val rxJava2RxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"

    const val gson = "com.google.code.gson:gson:${Versions.gson}"

    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    const val retrofitRxJava2Adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitRxJava2}"

    const val okhttpLogging = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLogging}"

    const val lifecycleExtension = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    const val lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.lifecycle}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    const val circularImage = "com.mikhaellopez:circularimageview:${Versions.circularImage}"

    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val lifecycleViewmodelKt = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.1.0"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val espresso = "3.2.0"
        const val testRunner = "1.2.0"
        const val mockito = "3.0.0"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val mockitoCore = "org.mockito:mockito-core:${Versions.mockito}"
    const val mockitoInline = "org.mockito:mockito-inline:${Versions.mockito}"
    const val mockitoCoreArc = "android.arch.core:core-testing:1.1.1"
}