plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_FRAMEWORK_VERSION
    id("io.spring.dependency-management") version PluginVersions.SPRING_DEPENDENCY_MANAGEMENT_VERSION
    kotlin("plugin.spring") version PluginVersions.PLUGIN_SPRING_VERSION
    kotlin("plugin.jpa") version PluginVersions.PLUGIN_JPA_VERSION
}

dependencies {

    // multi module
    implementation(project(":Kotlin-domain"))

    // jpa
    implementation(Dependency.JPA)

    // db-connector
    implementation(Dependency.REDIS)
    runtimeOnly(Dependency.MYSQL)

    // web
    implementation(Dependency.WEB)

    // security
    implementation(Dependency.SPRING_SECURITY)

    // property
    implementation(Dependency.PROPERTIES_SCAN)

    // validation
    implementation(Dependency.VALIDATION)

    // jwt
    implementation(Dependency.JWT)

    // transaction
    implementation(Dependency.TRANSACTION)

    // sentry
    implementation(Dependency.SENTRY)

    // logback
    implementation(Dependency.LOGBACK)

    // mapstruct
    implementation(Dependency.MAPSTRUCT)
    implementation(Dependency.MAPSTRUCT_PROCESSOR)

    // configuration
    annotationProcessor(Dependency.CONFIGURATION_PROCESSOR)

}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
}

tasks.getByName<Jar>("jar") {
    enabled = false
}