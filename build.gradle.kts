import com.github.gradle.node.npm.task.NpmTask
import com.github.gradle.node.npm.task.NpxTask

plugins {
    java
    id("org.springframework.boot") version "3.2.1"
    id("io.spring.dependency-management") version "1.1.4"
    id("com.github.node-gradle.node") version "7.0.1"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    compileOnly("org.projectlombok:lombok")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    annotationProcessor("org.projectlombok:lombok")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

sourceSets {
    getByName("main") {
        resources {
            exclude("static/css/application.css")
        }
    }
}

node {
    download.set(true)
    version.set("20.11.0")
    npmInstallCommand.set("ci")
}

tasks.register<NpxTask>("buildTailwind") {
    description = "Build tailwindcss"
    group = "build"
    dependsOn("npmInstall")
    command.set("tailwindcss")
    args.set(
        listOf(
            "-i",
            "./src/main/resources/static/css/application.css",
            "-o",
            "./build/resources/main/static/css/application.css",
        )
    )
}

tasks.getByName("compileJava").dependsOn("buildTailwind")
