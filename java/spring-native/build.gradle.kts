import org.springframework.boot.gradle.plugin.SpringBootPlugin

plugins {
  id("java")
  id("org.springframework.boot") version "3.4.0"
  id("org.graalvm.buildtools.native") version "0.10.4"
}

description = "OpenTelemetry Example for Spring native images"
val moduleName by extra { "io.opentelemetry.example.native" }

dependencies {
  implementation(platform(SpringBootPlugin.BOM_COORDINATES))
  implementation(platform("io.opentelemetry.instrumentation:opentelemetry-instrumentation-bom:2.10.0"))
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
  implementation("com.h2database:h2")
  implementation("io.opentelemetry.instrumentation:opentelemetry-spring-boot-starter")
  implementation("io.opentelemetry.contrib:opentelemetry-samplers:1.33.0-alpha")
}