plugins {
  pluginCompose()
  pluginKotlinMultiplatform()
  pluginKotlinAndroidExtension()
  pluginAndroidLibrary()
}

kotlin {
  metadata {
    compilations.all {
      kotlinOptions {
        //开启"expect"关键字。
        freeCompilerArgs += "-Xopt-in=kotlin.RequiresOptIn"
        freeCompilerArgs +="-opt-in=kotlin.RequiresOptIn"
      }
    }
  }
  
  android {
    //这两个都行。
    publishAllLibraryVariants()
//    publishLibraryVariants("release", "debug")
  }
  /**
   * 方法：fun jvm(name: String = "jvm")
   * 1、参数是a，就是“aMain”和“aTest”目录。
   * 2、这里是：“desktopMain”和“desktopTest”目录。
   */
  jvm {
    compilations.all {
      kotlinOptions.jvmTarget = "11"
    }
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
        
        api(project(":lib-commonx"))
//        implementation(project(":lib-"))
      }
    }
    val commonTest by getting {
      dependencies {
        implementation(test.Kotlin.test)
      }
    }
    val jvmMain by getting {
      dependencies {
      }
    }
    val jvmTest by getting {
      dependencies {
      }
    }
    val androidMain by getting {
//      dependsOn(jvmMain)
      dependencies {
        implementation(dep.Android.appCompat)
        implementation(dep.Android.coreKtx)
      }
    }
    val androidTest by getting {
      dependencies {
        implementation(dep.Java.junit)
      }
    }
    
    //==================================================
    /**
     * named("androidMain") 等于 val androidMain by getting
     */
  }
  
}

//////////////////////////////////////////////////

android {
  compileSdkVersion = param.Android.compileSdkVersion
  buildToolsVersion = param.Android.buildToolsVersion
  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
  defaultConfig {
    minSdk = param.Android.minSdkVersion
    targetSdk = param.Android.targetSdkVersion
  }
}

setBuildDir(project.projectDir.parent + "/.builds/.${name}Build")