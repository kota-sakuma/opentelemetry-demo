pluginManagement {
  plugins {
    id("com.diffplug.spotless") version "6.25.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("com.google.protobuf") version "0.9.4"
    id("org.gradle.toolchains.foojay-resover-convention") version "0.9.0"
    id("com.google.cloud.tools.jib") version "3.4.4"
    id("com.gradle.develocity") version "3.18.2"
  }
}

plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "0.9.0"
  id("com.gradle.develocity")
}

develocity {
  buildScan {
    publishing.onlyIf { System.getenv("CI") != null }
    termsOfUseUrl.set("https://gradle.com/help/legal-terms-of-use")
    termsOfUseAgree.set("yes")
  }
}

rootProject.name = "opentelemetry-java-examples"
include(
  ":opentelemetry-examples-autoconfigure",
  ":opentelemetry-examples-declarative-configuration",
  ":opentelemetry-examples-http",
  ":opentelemetry-examples-jaeger",
  ":opentelemetry-examples-javaagent",
  ":opentelemetry-examples-log-appender",
  ":opentelemetry-examples-logging",
  ":opentelemetry-examples-manual-tracing",
  ":opentelemetry-examples-metrics",
  ":opentelemetry-examples-micrometer-shim",
  ":opentelemetry-examples-otlp",
  ":opentelemetry-examples-prometheus",
  ":opentelemetry-examples-sdk-usage",
  ":opentelemetry-examples-telemetry-testing",
  ":opentelemetry-examples-zipkin",
  ":opentelemetry-examples-spring-native",
  ":opentelemetry-examples-kotlin-extention",
  ":opentelemetry-examples-grpc",
  ":opentelemetry-examples-resource-detection-gcp",
  ":doc-snippets:api",
  ":doc-snippets:configuration",
  ":doc-snippets:getting-started",
  ":doc-snippets:exporters",
  ":doc-snippets:spring-starter",
)

rootProject.children.forEach {
  if (it.name != "doc-snippets") {
    it.projectDir = file(
      "$rootDir/${it.name}".replace("opentelemetry-examples-", "")
    )
  }
}