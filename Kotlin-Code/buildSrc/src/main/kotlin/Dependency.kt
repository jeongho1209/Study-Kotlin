object Dependency {

    // validation
    const val VALIDATION = "org.springframework.boot:spring-boot-starter-validation"

    // web
    const val WEB = "org.springframework.boot:spring-boot-starter-web"

    // jackson
    const val JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin:${DependencyVersion.JACKSON_VERSION}"

    // jpa
    const val JPA = "org.springframework.boot:spring-boot-starter-data-jpa"

    // reflect
    const val REFLECT = "org.jetbrains.kotlin:kotlin-reflect"

    // jdk8
    const val STDLIB_JDK8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"

    // ktlint
    const val KTLINT = "com.pinterest:ktlint:${DependencyVersion.KTLINT_VERSION}"

    // security
    const val SPRING_SECURITY = "org.springframework.boot:spring-boot-starter-security"
    const val JWT = "io.jsonwebtoken:jjwt:0.9.0"

    // redis
    const val REDIS = "org.springframework.boot:spring-boot-starter-data-redis"

    // s3
    const val CLOUD_AWS = "org.springframework.cloud:spring-cloud-starter-aws"

    // queryDSL
    const val QUERYDSL = "com.querydsl:querydsl-jpa:${DependencyVersion.QUERYDSL}"
    const val QUERYDSL_PROCESSOR = "com.querydsl:querydsl-apt:${DependencyVersion.QUERYDSL}:jpa"

    // cloud aws dependencies
    const val CLOUD_AWS_DEPENDENCIES =
            "org.springframework.cloud:spring-cloud-aws-dependencies:${DependencyVersion.CLOUD_AWS}"

    // open feign
    const val OPENFEIGN = "org.springframework.cloud:spring-cloud-starter-openfeign:${DependencyVersion.OPENFEIGN}"

    // MySQL
    const val MYSQL = "mysql:mysql-connector-java"

    // property
    const val PROPERTIES_SCAN = "org.springframework.boot:spring-boot-configuration-processor"

    // spring transactional
    const val TRANSACTION = "org.springframework:spring-tx:${DependencyVersion.TRANSACTION}"

    // sentry
    const val SENTRY = "io.sentry:sentry-spring-boot-starter:${DependencyVersion.SENTRY}"

    // logback
    const val LOGBACK = "io.sentry:sentry-logback:${DependencyVersion.LOGBACK}"

    // mapstruct
    const val MAPSTRUCT = "org.mapstruct:mapstruct:${DependencyVersion.MAPSTRUCT_VERSION}"
    const val MAPSTRUCT_PROCESSOR = "org.mapstruct:mapstruct-processor:${DependencyVersion.MAPSTRUCT_VERSION}"

    // configuration
    const val CONFIGURATION_PROCESSOR = "org.springframework.boot:spring-boot-configuration-processor"

}