import type.kmp.configPublishPlan1
import util.applySignParamPlan1

buildscript {
  repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  
    gradlePluginPortal()
    google()
    mavenCentral()
    
    mavenLocal()
  }
  dependencies {
    classpath("com.squareup.sqldelight:gradle-plugin:1.5.3")
    //解析json。
    classpath(kotlin("serialization", ver.Jetbrain.KotlinVersion))
    //kotlin的gradle插件。
    classpath(classpath.KotlinGradlePlugin)
    //安卓构建工具。7.0版本以上时，需要对应相应的gradle版本。
    classpath(classpath.AndroidToolsBuildGradle)
//    classpath("com.android.tools.build:gradle:4.0.1")
  }
}

allprojects {
  repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
    mavenCentral()
    mavenLocal()
  }
}

//applySignParamPlan1()

//配置子模块的发布信息。
subprojects {
  configPublishPlan1()
}