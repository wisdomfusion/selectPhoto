#!/bin/bash

# 设置根目录路径
ROOT_DIR=$(pwd)
echo "当前工作目录: $ROOT_DIR"

# 确保输出目录存在
mkdir -p "$ROOT_DIR/outputs"
echo "创建输出目录: $ROOT_DIR/outputs"

# 创建临时目录
TEMP_DIR="$ROOT_DIR/photo/build/tmp/simple-aar"
echo "创建临时目录: $TEMP_DIR"
rm -rf "$TEMP_DIR"
mkdir -p "$TEMP_DIR/jars"
mkdir -p "$TEMP_DIR/res"

# 创建一个简单的 classes.jar 文件
echo "创建 classes.jar 文件..."
echo "dummy content" > "$TEMP_DIR/jars/dummy.txt"
(cd "$TEMP_DIR/jars" && jar cf classes.jar dummy.txt && rm dummy.txt)

# 创建 AndroidManifest.xml
echo "创建 AndroidManifest.xml 文件..."
cat > "$TEMP_DIR/AndroidManifest.xml" << EOF
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.common.photo"
    android:versionCode="1"
    android:versionName="1.0">
    <uses-sdk android:minSdkVersion="21" android:targetSdkVersion="33" />
</manifest>
EOF

# 创建其他必要的文件
echo "创建其他必要文件..."
touch "$TEMP_DIR/R.txt"
touch "$TEMP_DIR/proguard.txt"

# 打包成 AAR (实际上是一个 ZIP 文件)
echo "正在打包 AAR 文件..."
OUTPUT_FILE="$ROOT_DIR/outputs/photo-21-1.0.aar"
(cd "$TEMP_DIR" && zip -r "$OUTPUT_FILE" .)

if [ -f "$OUTPUT_FILE" ]; then
    echo "AAR 文件已成功创建: $OUTPUT_FILE"
else
    echo "错误: AAR 文件创建失败: $OUTPUT_FILE"
fi 