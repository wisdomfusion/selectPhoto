# SelectPhoto 项目

这是一个用于图片选择和查看的 Android 库项目。

## 项目结构

- **app**: 示例应用模块
- **photo**: 核心库模块

## 构建说明

本项目使用 Gradle 7.6.4 构建。

### 构建步骤

1. 克隆仓库：
   ```
   git clone https://github.com/huzhifei/selectPhoto.git
   cd selectPhoto
   ```

2. 构建项目：
   ```
   ./gradlew build -x lint -x lintDebug -x lintRelease
   ```

3. 安装示例应用：
   ```
   ./gradlew :app:installDebug
   ```

4. 导出 AAR 文件（用于作为第三方库引入到其他项目）：
   ```
   # 方法一：使用提供的 shell 脚本（推荐）
   ./create_aar.sh
   
   # 方法二：使用 Gradle 任务（如果构建系统改动）
   ./gradlew :photo:assembleRelease
   ```
   
   AAR 文件会生成在项目根目录的 `outputs` 文件夹下，名称为 `photo-21-1.0.aar`。

## 作为第三方库集成

有两种方式可以集成该库：

1. **通过 JitPack 依赖**：适合发布版本的场景，使用简单
2. **本地 AAR 文件依赖**：适合自定义修改后的场景

### 使用本地 AAR 集成

1. 将生成的 `photo-21-1.0.aar` 文件复制到你的应用项目的 `libs` 目录
2. 在应用的 `build.gradle` 或 `build.gradle.kts` 中添加：

```kotlin
dependencies {
    implementation(files("libs/photo-21-1.0.aar"))
}
```

详细集成指南请参阅 [photo/README.md](photo/README.md)。

## 为什么使用 shell 脚本生成 AAR？

由于在 Gradle 构建过程中可能会遇到 Lint 和注解处理相关的问题，使用独立的 shell 脚本可以绕过这些问题，快速生成一个干净的 AAR 文件。这种方法特别适合将该库作为第三方依赖添加到大型工程项目中。

## 许可证

// 在这里添加许可证信息 