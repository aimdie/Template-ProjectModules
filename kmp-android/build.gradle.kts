plugins {
  kotlin("multiplatform")
  kotlin("plugin.serialization")
  
  id("kotlin-android-extensions")
  id("com.android.library")
}

kotlin {
  
  metadata {
    compilations.all {
      kotlinOptions {
        //开启"expect"关键字。
        freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
      }
    }
  }
  
  android{
//    publishAllLibraryVariants()
    publishLibraryVariants("release", "debug")
  }
  /**
   * 给各个模块添加依赖。
   */
  sourceSets {
    named("commonMain") {
      dependencies {
        implementation(dep.Kotlin.Stdlib)
        implementation(dep.Kotlinx.CoroutinesCore)
        implementation(dep.Kotlinx.SerializationJson)
        
//        implementation(project(":lib-common"))
      }
    }
    named("commonTest") {
      dependencies {
        implementation(dep.Kotlin.Test.Junit)
      }
    }
    //==================================================
  
    named("androidMain"){
    }
    named("androidTest"){
    }
    //==================================================
    /**
     * 等效于这些方法：
     * val commonMain by getting
     * val commonTest by getting
     * val jvmMain by getting
     */
  }
}
//////////////////////////////////////////////////
kotlin{
}
//android {
//  compileSdkVersion(31)
//  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
//  defaultConfig {
//    minSdkVersion(24)
//    targetSdkVersion(31)
//  }
//  compileOptions {
//    sourceCompatibility = JavaVersion.VERSION_1_8
//    targetCompatibility = JavaVersion.VERSION_1_8
//  }
//}
android {
  compileSdkVersion = param.Android.compileSdkVersion
  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
  defaultConfig {
    minSdk = param.Android.minSdkVersion
    targetSdk =param.Android.targetSdkVersion
  }
}