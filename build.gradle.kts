plugins {
    java
}

repositories {
    mavenCentral()
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "com.example.Main"
    }
}
