object Dependency {

    // validation
    const val VALIDATION = "org.springframework.boot:spring-boot-starter-validation"

    // web
    const val WEB = "org.springframework.boot:spring-boot-starter-web"

    // jackson
    const val JACKSON = "com.fasterxml.jackson.module:jackson-module-kotlin"

    // jpa
    const val JPA = "org.springframework.boot:spring-boot-starter-data-jpa"

    // reflect
    const val REFLECT = "org.jetbrains.kotlin:kotlin-reflect"

    // jdk8
    const val STDLIB_JDK8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8"

    // security
    const val SPRING_SECURITY = "org.springframework.boot:spring-boot-starter-security"
    const val JWT = "io.jsonwebtoken:jjwt:0.9.1"

    // redis
    const val REDIS = "org.springframework.boot:spring-boot-starter-data-redis"

    // queryDSL
    const val QUERYDSL = "com.querydsl:querydsl-jpa:${DependencyVersion.QUERYDSL}"
    const val QUERYDSL_PROCESSOR = "com.querydsl:querydsl-apt:${DependencyVersion.QUERYDSL}:jpa"

    // open feign
    const val OPENFEIGN = "org.springframework.cloud:spring-cloud-starter-openfeign:${DependencyVersion.OPENFEIGN}"

    // MySQL
    const val MYSQL = "mysql:mysql-connector-java"

    // property
    const val PROPERTIES_SCAN = "org.springframework.boot:spring-boot-configuration-processor"

    // sentry
    const val SENTRY = "io.sentry:sentry-spring-boot-starter:${DependencyVersion.SENTRY}"

    // logback
    const val LOGBACK = "io.sentry:sentry-logback:${DependencyVersion.LOGBACK}"
}