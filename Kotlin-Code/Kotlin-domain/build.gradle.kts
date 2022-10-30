plugins {
    kotlin("plugin.allopen") version "1.6.21"
}

dependencies {

    implementation("org.springframework:spring-context:5.3.23")
    implementation("org.springframework:spring-tx:5.3.23")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.5")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
}