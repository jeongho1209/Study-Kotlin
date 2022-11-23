import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version PluginVersions.SPRING_BOOT_FRAMEWORK_VERSION
    id("io.spring.dependency-management") version PluginVersions.SPRING_DEPENDENCY_MANAGEMENT_VERSION
    kotlin("jvm") version PluginVersions.JVM_VERSION
    kotlin("plugin.spring") version PluginVersions.PLUGIN_SPRING_VERSION
    kotlin("plugin.jpa") version PluginVersions.PLUGIN_JPA_VERSION
    kotlin("kapt") version PluginVersions.KAPT_VERSION
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(Dependency.VALIDATION)
    implementation(Dependency.WEB)
    implementation(Dependency.JACKSON)
    implementation(Dependency.JPA)
    implementation(Dependency.REFLECT)
    implementation(Dependency.STDLIB_JDK8)
    implementation(Dependency.SPRING_SECURITY)
    implementation(Dependency.REDIS)
    kapt(Dependency.QUERYDSL_PROCESSOR)
    implementation(Dependency.QUERYDSL)
    runtimeOnly(Dependency.MYSQL)
    implementation(Dependency.OPENFEIGN)
    implementation(Dependency.JWT)

}

kotlin.sourceSets.main {
    kotlin.srcDir("$buildDir/generated/source/kapt/main")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()

}

allOpen {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

noArg {
    annotation("javax.persistence.Entity")
    annotation("javax.persistence.MappedSuperclass")
    annotation("javax.persistence.Embeddable")
}

tasks.getByName<Jar>("jar") {
    enabled = false
}