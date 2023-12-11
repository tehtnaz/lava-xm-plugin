plugins {
    java
    `maven-publish`
    alias(libs.plugins.lavalink)
}

group "space.essem"
version "0.3.0"

lavalinkPlugin {
    name = "lava-xm-plugin"
    apiVersion = libs.versions.lavalink.api
    serverVersion = libs.versions.lavalink.server
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
    maven { url = uri("https://dankmemeitthefrog.github.io/maven-repo") }
}

dependencies {
    compileOnly("dev.arbjerg.lavalink:plugin-api:4.0.0")
    implementation("dev.arbjerg:lavaplayer:2.0.4")
    implementation("org.helllabs:libxmp-java:1.0.1")
}

// shadowJar {
//     def impl = project.configurations.implementation
//     impl.canBeResolved(true)
//     configurations = [impl]
//     archiveClassifier.set("")
// }

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
}
