plugins {
  kotlin("multiplatform")
  kotlin("plugin.serialization")
  id("com.android.library")
  //kotlin-parcelize必须在com.android.library之后。
//  id("kotlin-parcelize")
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
  
  /**
   * 方法：fun jvm(name: String = "jvm")
   * 1、他就是目录：jvmMain。
   */
  jvm {
    compilations.all {
      kotlinOptions.jvmTarget = "1.8"
    }
    testRuns["test"].executionTask.configure {
      useJUnit()
    }
  }
  
  android{
    //这两个都行。
    publishAllLibraryVariants()
//    publishLibraryVariants("release", "debug")
  }
  
  /**
   * 给各个模块添加依赖。
   */
  sourceSets {
    named("commonMain") {
      dependencies {
        implementation(dep.Kotlin.stdlib)
        implementation(dep.Kotlinx.coroutinesCore)
        implementation(dep.Kotlinx.serializationJson)
      }
    }
    named("commonTest") {
      dependencies {
        implementation(test.Kotlin.test)
      }
    }
    
    named("jvmMain"){
    
    }
    
    named("jvmTest"){
    
    }
    
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

android {
  compileSdkVersion = param.Android.compileSdkVersion
  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
  defaultConfig {
    minSdk = param.Android.minSdkVersion
    targetSdk =param.Android.targetSdkVersion
  }
}

setBuildDir(project.projectDir.parent + "/.builds/.${name}Build")