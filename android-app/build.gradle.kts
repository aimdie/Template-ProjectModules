plugins {
  pluginCompose()
  pluginAndroidApplication()
  /**
   * 如果不加该插件：
   * 1、可以生成APK。
   * 2、会报错：native库缺失。
   */
  pluginKotlinAndroid()
}

group = "cn.ace"
version = "29.8.13"

android {
  compileSdkVersion = param.Android.compileSdkVersion
  buildToolsVersion = param.Android.buildToolsVersion
  defaultConfig {
    applicationId = "cn.ace.android"
    
    minSdk = param.Android.minSdkVersion
    targetSdk = param.Android.targetSdkVersion
    versionCode = 1
    versionName = "1.0"
  }
  
  buildTypes {
    release {
      isMinifyEnabled = false
//      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
      
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  
  kotlinOptions {
    jvmTarget = "1.8"
  }
  
  buildFeatures {
    compose = true
  }
  
  /**
   * 排除：不同模块、相同路径的文件。
   */
  packagingOptions {
    exclude("META-INF/DEPENDENCIES")
    exclude("META-INF/LICENSE")
    exclude("META-INF/LICENSE.txt")
    exclude("META-INF/license.txt")
    exclude("META-INF/NOTICE")
    exclude("META-INF/NOTICE.txt")
    exclude("META-INF/notice.txt")
    exclude("META-INF/ASL2.0")
    exclude("META-INF/*.kotlin_module")
    exclude("META-INF/LICENSE.md")
    exclude("META-INF/LICENSE-notice.md")
//    exclude("")
//    exclude("")
//    exclude("")
//    exclude("")
//    exclude("")
  }
}
dependencies {
//  implementation(project(":common"))
  implementation(dep.Java.junit)
  
  implementation(dep.Android.appCompat)
  implementation(dep.Android.activity)
  implementation(dep.Android.constraintLayout)
  
  implementation(dep.Compose.material)
  implementation(dep.Compose.ui)
}

setBuildDir(project.projectDir.parent + "/.${name}Build")