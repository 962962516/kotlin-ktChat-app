import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.9"
	id("io.spring.dependency-management") version "1.1.0"
	//kotlin("jvm") version "1.6.21"
	kotlin("jvm") version "1.9.0"
	kotlin("plugin.spring") version "1.6.21"
	kotlin("plugin.allopen") version "1.6.21"
	kotlin("kapt") version "1.9.0"
	kotlin("plugin.jpa") version "1.6.21"
}

group = "com.lingocat.app"
version = "0.0.1-beta"

java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
	mavenCentral()
	maven {
		setUrl("https://azureai.azureedge.net/maven/")
	}
}

springBoot {
	buildInfo()
}

allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.Embeddable")
	annotation("javax.persistence.MappedSuperclass")
}