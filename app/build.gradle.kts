plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.common.select_pictures"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.common.select_pictures"
        minSdk = 21
        targetSdk = 33
        versionCode = 1
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
        }
    }
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    
    kotlinOptions {
        jvmTarget = "11"
    }
    
    buildFeatures {
        viewBinding = true
    }
    
    // 增强禁用Lint检查
    lintOptions {
        isAbortOnError = false
        isCheckReleaseBuilds = false
        isWarningsAsErrors = false
        isIgnoreWarnings = true
        disable("all")
    }
    
    // 禁用Lint检查
    lint {
        abortOnError = false
        checkReleaseBuilds = false
        disable += listOf("all")
        // 完全跳过 lint 检查
        checkDependencies = false
        checkGeneratedSources = false
        checkTestSources = false
        checkReleaseBuilds = false
    }
}

// 禁用 lint 相关任务
tasks.configureEach {
    if (name.contains("lint") || name.contains("Lint")) {
        enabled = false
    }
}

configurations.all {
    resolutionStrategy {
        // 强制所有模块使用相同版本的Kotlin标准库
        force("org.jetbrains.kotlin:kotlin-stdlib:1.7.10")
        force("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.7.10")
        force("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.10")
        force("org.jetbrains.kotlin:kotlin-stdlib-common:1.7.10")
        force("org.jetbrains.kotlin:kotlin-reflect:1.7.10")
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    implementation(project(":photo"))
    implementation("com.github.bumptech.glide:glide:4.16.0")
}