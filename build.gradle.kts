import publish.configPublishPlan1

//import publish.configPublishPlan1
//println("rootGradleKts:开始")
buildscript {
//  println("rootGradleKts:buildscript")
  initVersions(rootProject)
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
  }
  
  dependencies {
    classpath(classpath.kotlinGradlePlugin)
    classpath(classpath.androidToolsBuildGradle)
    classpath(classpath.kotlinSeriallization)
  }
}

//println("rootGradleKts:all之前")
allprojects {
//  println("rootGradleKts:allprojects")
  repositories {
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
    mavenCentral()
    mavenLocal()
  }
}

//println("rootGradleKts:all之后")
//配置子模块的发布信息。
subprojects {
//  println("rootGradleKts:subprojects")
  configPublishPlan1()
}
//println("rootGradleKts:结束")
