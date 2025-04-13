// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.7.10" apply false
    id("com.android.library") version "7.2.2" apply false
}
buildscript {
    dependencies {
        classpath("com.github.dcendents:android-maven-gradle-plugin:2.1")
    }
}

// 全局处理构建问题
subprojects {
    tasks.withType<org.gradle.api.tasks.bundling.Zip> {
        isZip64 = true
    }
    
    // 确保这些配置只对当前项目生效，不会被传递到使用这个库的项目中
    plugins.withId("com.android.library") {
        afterEvaluate {
            tasks.matching { task ->
                task.name.startsWith("lint") || 
                task.name.contains("Lint") || 
                task.name.contains("extractAnnotations") ||
                task.name.contains("extract") && task.name.contains("Annotations") ||
                task.name == "extractReleaseAnnotations" ||
                task.name == "extractDebugAnnotations" ||
                task.name == "syncDebugLibJars" ||
                task.name == "syncReleaseLibJars" || 
                task.name.contains("typedefs") ||
                task.name.contains("Typedefs") ||
                task.name.contains("LibraryAarJars") ||
                task.name.contains("Aar")
            }.configureEach {
                enabled = false
            }
        }
    }
}