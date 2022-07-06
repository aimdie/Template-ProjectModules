plugins {
  kotlin("multiplatform")
  kotlin("plugin.serialization")
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
  
  /**
   * 给各个模块添加依赖。
   */
  sourceSets {
    named("commonMain") {
      dependencies {
        implementation(dep.Kotlin.stdlib)
        implementation(dep.Kotlinx.coroutinesCore)
        implementation(dep.Kotlinx.serializationJson)
  
//        implementation(project(":lib-commonx"))
      }
    }
    
    named("commonTest") {
      dependencies {
        implementation(test.Kotlin.test)
      }
    }
    val jvmMain by getting{}
    val jvmTest by getting{}
    //==================================================
    /**
     * 等效于这些方法：
     * val commonMain by getting
     * val commonTest by getting
     * val jvmMain by getting
     */
  }
  
}

setBuildDir(project.projectDir.parent + "/.builds/.${name}Build")