object ApplicationId {
    val id = "com.amplemind.bodypeace"
}

object Modules {
    val app = ":app"
    val navigation = ":navigation"
    val processor = ":codegen"
    val annotation = ":annotation_test"

    val cache = ":common:cache"
    val network = ":common:network"

    val presentation = ":common:presentation"

    val home = ":features:home"
    val login = ":features:login"
    val sample = ":sample"
    val launcher = ":features:launcher"
}

object Releases {
    val versionCode = 26
    val versionName = "2.0."
}


object Versions {
    val gradle = "3.2.1"

    val compileSdk = 28
    val minSdk = 22
    val targetSdk = 28

    val gms = "4.0.2"

    val googleServices = "4.2.0"
    val firebase = "16.0.4"
    val googleAuth = "16.0.1"

    val fabric = "1.27.0"

    val appcompat = "1.0.2"
    val design = "1.0.0-alpha1"
    val cardview = "1.0.0"
    val recyclerview = "1.0.0"
    val maps = "15.0.1"
    val legacyVersion = "1.0.0"

    val ktx = "1.0.0-alpha1"

    val kotlin = "1.3.21"
    val timber = "4.7.1"
    val rxjava = "2.2.5"
    val rxkotlin = "2.3.0"
    val retrofit = "2.5.0"
    val loggingInterceptor = "3.12.1"
    val glide = "4.8.0"
    val moshi = "1.8.0"
    val lifecycle = "2.0.0"
    val leakCanary = "1.6.3"
    val crashlytics = "2.9.8"
    val koin = "2.0.0-alpha-6"

    val billing = "2.0.0"

    val constraint = "1.1.3"

    val runer = "1.1.0-alpha4"
    val espresso = "3.1.0-alpha4"

    val playCore = "1.3.6"

    val junit = "4.12"
    val assertjCore = "3.11.1"
    val mockitoKotlin = "2.0.0-RC1"
    val mockitoInline = "2.23.4"

    val navigationVersion = "2.0.0"
    val rxbindingVersion = "2.1.1"
    val rxbindingKotlinVersion = "2.0.0"

    val lottieVersion = "3.0.0"

    val rxPaper = "1.4.0"

    val loopview = "1.1.4"

    val roomVersion = "1.1.1"

    val supportDesign = "28.0.0"

    val dynamic = "16.1.8"
}

object Libraries {
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    val testRunner = "androidx.test.runner.AndroidJUnitRunner"

    val ktx = "androidx.core:core-ktx:${Versions.ktx}"

    val crop = "com.naver.android.helloyako:imagecropview:1.2.2"

    val exoplayer = "com.google.android.exoplayer:exoplayer:2.10.1"
    val exoPlayerHLS = "com.google.android.exoplayer:exoplayer-hls:2.8.3"
    val exoCore = "com.google.android.exoplayer:exoplayer-core:2.10.0"
    val exoDash = "com.google.android.exoplayer:exoplayer-dash:2.10.0"
    val exoPlayerUI = "com.google.android.exoplayer:exoplayer-ui:2.10.0"

    val maps = "com.google.android.gms:play-services-maps:${Versions.maps}"

    val timber = "com.jakewharton.timber:timber:${Versions.timber}"

    val billing = "com.android.billingclient:billing:${Versions.billing}"

    val rxjava = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
    val rxkotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"

    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val rxjavaAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    val gson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"

    val moshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}"

    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

    val rxpaper = "com.github.pakoito:RxPaper2:${Versions.rxPaper}"
    val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"

    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:${Versions.lifecycle}"

    val leakCanaryAndroid = "com.squareup.leakcanary:leakcanary-android:${Versions.leakCanary}"
    val leakCanaryAndroidNoOp = "com.squareup.leakcanary:leakcanary-android-no-op:${Versions.leakCanary}"
    val leakCanaryAndroidSupportFragment = "com.squareup.leakcanary:leakcanary-support-fragment:${Versions.leakCanary}"

    val crashlytics = "com.crashlytics.sdk.android:crashlytics:${Versions.crashlytics}"

    val koinAndroid = "org.koin:koin-android:${Versions.koin}"
    val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.koin}"

    val dynamicLink = "com.google.firebase:firebase-dynamic-links:${Versions.dynamic}"

}

object BindingDependencies{
    val rxBinding = "com.jakewharton.rxbinding2:rxbinding:${Versions.rxbindingVersion}"
    val rxBindingDesing = "com.jakewharton.rxbinding2:rxbinding-design:${Versions.rxbindingVersion}"
    val rxBindingKotlin = "com.jakewharton.rxbinding2:rxbinding-kotlin:${Versions.rxbindingKotlinVersion}"
}

object LottieLibrary{
    val lottie = "com.airbnb.android:lottie:${Versions.lottieVersion}"
}

object NavigationLibraries {
    val navigationFragmentLibrary = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationVersion}"
    val navigationUILibrary = "androidx.navigation:navigation-ui-ktx:${Versions.navigationVersion}"
}

object LibrariesExternal {
    val loopingviewpager = "com.asksira.android:loopingviewpager:${Versions.loopview}"
}

object LibrariesRoom {
    val roomCompiler = "android.arch.persistence.room:compiler:${Versions.roomVersion}"
    val roomRuntime = "android.arch.persistence.room:runtime:${Versions.roomVersion}"
    val roomRxjava = "android.arch.persistence.room:rxjava2:${Versions.roomVersion}"
}

object SupportLibraries {
    val appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    val design = "com.google.android.material:material:${Versions.design}"
    val cardview = "androidx.cardview:cardview:${Versions.cardview}"
    val recyclerview = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"
    val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
    val SupportDesign = "com.android.support:design:${Versions.supportDesign}"
    val legacy = "androidx.legacy:legacy-support-v4:${Versions.legacyVersion}"
}


object GoogleLibraries {
    val auth = "com.google.android.gms:play-services-auth:${Versions.googleAuth}"
    val playCore = "com.google.android.play:core:${Versions.playCore}"
    val facebook = "com.facebook.android:facebook-login:[4,5)"

}

object FirebaseLibraries {
    val auth = "com.google.firebase:firebase-auth:${Versions.firebase}"
    val core = "com.google.firebase:firebase-core:${Versions.firebase}"
}

object TestLibraries {
    val junit = "junit:junit:${Versions.junit}"
    val assertjCore = "org.assertj:assertj-core:${Versions.assertjCore}"
    val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockitoKotlin}"
    val mockitoInline = "org.mockito:mockito-inline:${Versions.mockitoInline}"
    val lifecycleTesting = "androidx.arch.core:core-testing:${Versions.lifecycle}"
    val runner = "androidx.test:runner:${Versions.runer}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}
