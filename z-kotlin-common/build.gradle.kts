
plugins {
  id("kotlin-platform-common")
}

//源码集
sourceSets{
  //main源码
  main{
    //添加一个资源目录“zresDir”
    resources.srcDir("zresDir")
  }
  //test源码
  test{
  
  }
}

kotlin{
  sourceSets{
    main{
      kotlin.srcDir("srcDir")
    }
    test{
      kotlin.srcDir("testDir")
    }
  }
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-stdlib-common:1.5.0")
//  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.0")
}
