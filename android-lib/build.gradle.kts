import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet

plugins {
  pluginCompose()
  pluginKotlinMultiplatform()
  pluginKotlinAndroidExtension()
  pluginAndroidLibrary()
}

kotlin{
  android()
  sourceSets {
    val commonMain by getting {
      dependencies {
        api(compose.runtime)
        api(compose.foundation)
        api(compose.material)
      }
    }
    
    val commonTest by getting {
      dependencies {
        implementation(dep.Kotlin.Test.junit)
      }
    }
    val androidMain: KotlinSourceSet by getting {
      dependencies {
      }
    }
  }
}

android {
  compileSdkVersion = param.Android.compileSdkVersion
  buildToolsVersion = param.Android.buildToolsVersion
  sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
  defaultConfig {
    minSdk = param.Android.minSdkVersion
    targetSdk = param.Android.targetSdkVersion
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
  }
}

setBuildDir(project.projectDir.parent + "/.${name}Build")