plugins {
    `java-library`
    `maven-publish`
    signing
    id("org.jreleaser") version "1.20.0"
}

repositories {
    mavenCentral()
}

group = "fr.slickteam.mistralai"
version = "0.3.0"
description = "Java client for Mistral AI - based on official Typescript client"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17

    withJavadocJar()
    withSourcesJar()
}

val jsonVersion: String by project
val junitVersion: String by project
val jacksonVersion: String by project

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.json:json:$jsonVersion")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")

    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-Xlint:unchecked")
}

tasks.jar {
    enabled = true
    // Remove `plain` postfix from jar file name
    archiveClassifier.set("")
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            withBuildIdentifier()
            pom {
                name.set("mistral-java-client")
                description.set("Java client for Mistral AI - based on official Typescript client")
                url.set("https://github.com/Slickteam/mistral-java-client")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://spdx.org/licenses/MIT.html")
                    }
                }
                developers {
                    developer {
                        id.set("Slickteam")
                        name.set("Slickteam")
                    }
                }
                scm {
                    connection.set("scm:git:https://github.com/Slickteam/mistral-java-client.git")
                    developerConnection.set("scm:git:git@github.com:Slickteam/mistral-java-client.git")
                    url.set("https://github.com/Slickteam/mistral-java-client")
                }
            }
        }
    }
    repositories {
        maven {
            url = layout.buildDirectory.dir("staging-deploy").get().asFile.toURI()
        }
    }
}

jreleaser {
    gitRootSearch = true

    project {
        description = "Java client for Mistral AI - based on official Typescript client"
        license = "MIT License"
    }

    signing {
        setActive("ALWAYS")
        armored = true
    }
    deploy {
        setActive("ALWAYS")
        maven {
            setActive("ALWAYS")
            mavenCentral {
                create("sonatype") {
                    setActive("ALWAYS")
                    url.set("https://central.sonatype.com/api/v1/publisher")
                    stagingRepositories.add("build/staging-deploy")
                }
            }
        }
    }

    release {
        github {
            skipRelease = true
            skipTag = true
            overwrite = false
            token = "none"
        }
    }
}