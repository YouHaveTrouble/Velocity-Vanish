plugins {
    id("java")
    kotlin("jvm") version "1.9.10"
    id("io.papermc.paperweight.userdev") version "1.5.5"
}

group = "ir.syrent.velocityvanish"
version = "1.0-SNAPSHOT"
description = "Modern vanish system for minecraft"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    paperweight.paperDevBundle("1.20.1-R0.1-SNAPSHOT")
}

tasks {
    java {
        withSourcesJar()
        withJavadocJar()
        toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    }

    assemble {
        dependsOn(reobfJar)
    }
}