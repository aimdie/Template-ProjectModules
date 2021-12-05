plugins {
  id(plugin.OrgJetbrainsCompose) version ver.Plugin.OrgJetbrainsCompose
  id("com.android.application")
  kotlin("android")
}

group = "cn.ace"
version = "29.8.13"

repositories {
  google()
}

dependencies {
//  implementation(project(":common"))
  implementation(dep.Java.junit)

  implementation(dep.Android.AppCompat)
  implementation(dep.Compose.Android.Activity)
  implementation(dep.Compose.Android.ConstraintLayout)
  
  implementation(dep.Compose.Material)
  implementation(dep.Compose.Ui)
}

android {

//  compileOptions {
//    sourceCompatibility(JavaVersion.VERSION_11)
//    targetCompatibility(JavaVersion.VERSION_11)
//  }
  
  compileSdkVersion = param.Android.compileSdkVersion
  buildToolsVersion = param.Android.buildToolsVersion
  defaultConfig {
    applicationId = "cn.ace.android"
    
    minSdk = param.Android.minSdkVersion
    targetSdk = param.Android.targetSdkVersion
    versionCode = 1
    versionName = "1.0"
  }
  buildFeatures {
    compose = true
  }
  
  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
    }
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