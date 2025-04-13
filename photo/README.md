# SelectPhoto 库

这是一个用于图片选择和查看的 Android 库。

## 集成指南

### 方式一：通过 JitPack 集成

在项目根目录的 `settings.gradle` 或 `settings.gradle.kts` 中添加 JitPack 仓库：

```kotlin
dependencyResolutionManagement {
    repositories {
        // 其他仓库...
        maven { url = uri("https://jitpack.io") }
    }
}
```

然后在应用模块的 `build.gradle` 或 `build.gradle.kts` 中添加依赖：

```kotlin
dependencies {
    implementation("com.github.huzhifei:selectPhoto:1.0")
}
```

### 方式二：使用本地 AAR 文件

1. 生成 AAR 文件：
   ```
   # 在项目根目录运行
   ./create_aar.sh
   ```
   
   这个脚本会自动创建一个干净的 AAR 文件，避开 Gradle 构建过程中可能遇到的问题。
   
   生成的 AAR 文件会位于项目根目录的 `outputs` 文件夹下，名称为 `photo-21-1.0.aar`。

2. 在应用项目中添加 AAR 依赖：

   首先，将 AAR 文件复制到你的项目中的 `libs` 目录（如果没有则创建）。

   在 `build.gradle` 或 `build.gradle.kts` 中添加依赖：

   ```kotlin
   dependencies {
       implementation(files("libs/photo-21-1.0.aar"))
   }
   ```

   或者使用 fileTree：

   ```kotlin
   dependencies {
       implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.aar"))))
   }
   ```

### 注意事项

由于在某些环境中 Gradle 构建过程可能会遇到 Lint 和注解处理相关的问题，我们提供了 shell 脚本 `create_aar.sh` 作为替代方案。这个脚本可以绕过这些问题，快速生成一个干净的 AAR 文件，特别适合将该库作为第三方依赖添加到大型工程项目中。

## 使用方法

// 在这里添加库的使用方法说明 