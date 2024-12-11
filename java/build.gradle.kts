plugins {
  id("com.diffplug.spotless")
  id("com.github.johnrengelman.shadow")
  id("java-library")
}

subprojects {
  apply(plugin = "com.diffplug.spotless")
  apply(plugin = "com.github.johnrengelman.shadow")
  apply(plugin = "java-library")

  group = "io.opentelemetry"
  version = "0.1.0-SNAPSHOT"

  repositories {
    mavenCentral()
  }

  dependencies {
    // using the bom ensures that all of your opentelemetry dependency versions are aligned
    implementation(platform("io.opentelemetry.instrumentation:opentelemetry-instrumentation-bom-alpha:2.10.0-alpha"))
  }

  spotless {
    java {
      targetExclude("**/generated/**")
      googleJavaFormat()
    }
  }
}
