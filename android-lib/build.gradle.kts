plugins {
//  id(plugin.OrgJetbrainsCompose) version ver.Plugin.OrgJetbrainsCompose
  id("com.android.library")
  kotlin("android")
}

dependencies {
//  implementation(project(":common"))
  implementation(dep.Java.Junit)
  
//  implementation(dep.Android.AppCompat)
//  implementation(dep.Compose.Android.Activity)
////  implementation(dep.Compose.Android.ConstraintLayout)
//
//  implementation(dep.Compose.Material)
//  implementation(dep.Compose.Ui)
}

android {

//  compileOptions {
//    sourceCompatibility(JavaVersion.VERSION_11)
//    targetCompatibility(JavaVersion.VERSION_11)
//  }
  
  compileSdkVersion = param.Android.compileSdkVersion
  buildToolsVersion = param.Android.buildToolsVersion
  defaultConfig {
    ndk {
      abiFilters.add("armeabi-v7a")
      abiFilters.add("x86")
    }
//    applicationId = "cn.ace.android"
    
    minSdk = param.Android.minSdkVersion
    targetSdk = param.Android.targetSdkVersion
  }
  sourceSets {
    getByName("main") {
      jniLibs {
        //对应项目目录的该目录，和main、test、androidTest。
        srcDirs("src/testlibs")
      }
    }
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