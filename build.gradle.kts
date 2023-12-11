plugins {
    "java"
    "application"
    "maven-publish"
    "com.github.johnrengelman.shadow" version "7.1.0"
}

group "space.essem"
version "0.3.0"
mainClassName = "org.springframework.boot.loader.JarLauncher"
sourceCompatibility = 11
compileJava.options.encoding = "UTF-8"

repositories {
    mavenCentral()
    maven { url "https://jitpack.io" }
    maven { url 'https://dankmemeitthefrog.github.io/maven-repo' }

    // Transitive dependencies
    maven { url "https://m2.dv8tion.net/releases" }
    jcenter()
    mavenLocal()
}

dependencies {
    compileOnly 'dev.arbjerg.lavalink:plugin-api:0.9.0'
    runtimeOnly "com.github.TheEssem.Lavalink:Lavalink-Server:dev-SNAPSHOT"
    implementation "org.helllabs:libxmp-java:1.0.1"
}

shadowJar {
    def impl = project.configurations.implementation
    impl.canBeResolved(true)
    configurations = [impl]
    archiveClassifier.set("")
}

publishing {
    publications {
        maven(MavenPublication) {
            pom {
                from components.java
            }
        }
    }
}
