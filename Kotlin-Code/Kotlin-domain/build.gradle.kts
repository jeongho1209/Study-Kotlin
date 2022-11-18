plugins {
    kotlin("plugin.allopen") version PluginVersions.ALLOPEN_VERSION
}

dependencies {

}

allOpen {
    annotation("com.example.kotlincode.annotation.ReadOnlyUseCase")
    annotation("com.example.kotlincode.annotation.UseCase")
}