plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // === Banco de Dados ===
    implementation("mysql:mysql-connector-java:8.0.33")

    // === Flyway (migrações) ===
    implementation("org.flywaydb:flyway-core:10.20.0")
    implementation("org.flywaydb:flyway-mysql:10.20.0")

    // === Lombok ===
    compileOnly("org.projectlombok:lombok:1.18.32")
    annotationProcessor("org.projectlombok:lombok:1.18.32")
    testCompileOnly("org.projectlombok:lombok:1.18.32")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.32")

    // === Testes (JUnit 5) ===
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21)) // ou 23 se quiser
    }
}
