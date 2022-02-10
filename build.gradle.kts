import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.3"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"

	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10" // kotlin("plugin.allopen")을 포함하고 있다
	kotlin("plugin.jpa") version "1.6.10" // kotlin("plugin.noarg")을 포함하고 있다
	kotlin("kapt") version "1.3.61" // querydsl 추가
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11
val querydslVersion = "4.4.0" // querydsl 추가

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	// querydsl 추가 start ---
	implementation("com.querydsl:querydsl-jpa:${querydslVersion}")
	kapt("com.querydsl:querydsl-apt:${querydslVersion}:jpa")
	kapt("org.hibernate.javax.persistence:hibernate-jpa-2.1-api:1.0.2.Final")
	kapt("org.springframework.boot:spring-boot-configuration-processor")
	compileOnly("org.springframework.boot:spring-boot-configuration-processor")
	// querydsl 추가 end ---

	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

// querydsl 추가 start ---
kotlin.sourceSets.main {
	setBuildDir("$buildDir")
}
// querydsl 추가 end ---

// 추가 start ---
noArg {
	annotation("javax.persistence.Entity")
}
allOpen {
	annotation("javax.persistence.Entity")
	annotation("javax.persistence.Embeddable")
	annotation("javax.persistence.MappedSuperclass")
}
// 추가 end ---

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
