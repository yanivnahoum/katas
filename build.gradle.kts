import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    kotlin("jvm") version "1.8.22"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.3")
    testImplementation("org.assertj:assertj-core:3.24.2")
}

tasks {
    test {
        useJUnitPlatform()
        testLogging {
            events("passed", "skipped", "failed")
            showStandardStreams = true
        }
    }

    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_17.toString()
        }
    }
}
