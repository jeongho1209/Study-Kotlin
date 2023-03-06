plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_FRAMEWORK_VERSION
    id("io.spring.dependency-management") version PluginVersions.SPRING_DEPENDENCY_MANAGEMENT_VERSION
    kotlin("plugin.spring") version PluginVersions.PLUGIN_SPRING_VERSION
}

dependencies {
    // impl project
    implementation(project(":Kotlin-domain"))
    implementation(project(":Kotlin-application"))

    // web
    implementation(Dependency.WEB)

    // validation
    implementation(Dependency.VALIDATION)
}

tasks.getByName<Jar>("bootJar") {
    enabled = false
}
