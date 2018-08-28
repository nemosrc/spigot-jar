# Gradle spigot-jar
Gradle uber jar task plugin for spigot plugin jar<br/>
그래들에서 spigot 플러그인을 위한 uberJar와 plugin.yml 작성을 도와주는 플러그인입니다.

## build.gradle
```gradle
plugins {
  id "com.nemosw.spigot-jar" version "1.0"
}

spigotJar {
//    write include projects(default allprojects)
//    include project(':api')
//    include project(':core')
    include subprojects

//    write exclude projects(default none)
//    exclude project(':')
//    exclude project(':deprecated')
    exclude project(':unsupported')
}
```
#### Dynamic plugin apply
```gradle
buildscript {
    repositories {
        maven {
            url "https://plugins.gradle.org/m2/"
        }
    }
    dependencies {
        classpath "gradle.plugin.com.nemosw:spigot-jar:1.0"
    }
}

apply plugin: "com.nemosw.spigot-jar"
```

### Link
https://plugins.gradle.org/plugin/com.nemosw.spigot-jar
