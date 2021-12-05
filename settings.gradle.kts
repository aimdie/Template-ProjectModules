pluginManagement {
  repositories {
    //gradle 国内镜像仓
    maven("https://maven.aliyun.com/repository/gradle-plugin")
    //google 国内镜像仓
    maven("https://maven.aliyun.com/repository/google")
    //jcenter 国内镜像仓
    maven("https://maven.aliyun.com/repository/jcenter")
    
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
    gradlePluginPortal()
    mavenCentral()
  }
}

//rootProject.name = ""
include(":z-kotlin-common")
include(":z-kotlin-jvm")
include(":z-kotlin-multiplatform")
include(":z-kotlin-multiplatform-compose")
include(":android-lib")
include(":android-app")
include(":kmp-android")
//include(":")

