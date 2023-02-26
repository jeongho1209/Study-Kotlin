plugins {
    kotlin("plugin.allopen") version PluginVersions.ALLOPEN_VERSION
}

dependencies {
    implementation(project(":Kotlin-domain"))
}

allOpen {
    annotation("com.example.kotlincode.common.UseCase")
    annotation("com.example.kotlincode.common.ReadOnlyUseCase")
}
