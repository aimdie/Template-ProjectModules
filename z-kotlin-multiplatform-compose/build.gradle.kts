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
      }
    }
  }
  android{
    //这两个都行。
    publishAllLibraryVariants()
//    publishLibraryVariants("release", "debug")
  }
  /**
   * 方法：fun jvm(name: String = "jvm")
   * 1、参数是a，就是“aMain”和“aTest”目录。
   * 2、这里是：“desktopMain”和“desktopTest”目录。
   */
  jvm("desktop") {
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
  
        api(compose.runtime)
        api(compose.foundation)
        api(compose.material)
//        api("cn.ace:lib-common:+")
//        api("cn.ace:lib-layout:+")
//        api("cn.ace:lib-place:+")
//        api("cn.ace:lib-color:+")
//        api("cn.ace:lib-missing:+")
//        implementation(project(":lib-"))
      }
    }
    named("commonTest") {
      dependencies {
        implementation(test.Kotlin.test)
      }
    }
    named("androidMain"){
      dependencies {
        api("androidx.appcompat:appcompat:1.2.0")
        api("androidx.core:core-ktx:1.3.1")
      }
    }
    named("androidTest"){
      dependencies {
        implementation("junit:junit:4.13")
      }
    }
    named("desktopMain"){
    
    }
    named("desktopTest"){
    
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
    targetSdk =param.Android.targetSdkVersion
  }
}

setBuildDir(project.projectDir.parent + "/.${name}Build")