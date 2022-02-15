import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"

	val kotlinVersion = "1.5.21"

	kotlin("jvm") version kotlinVersion
	kotlin("plugin.spring") version kotlinVersion // kotlin("plugin.allopen")을 포함하고 있다
	kotlin("plugin.jpa") version kotlinVersion // kotlin("plugin.noarg")을 포함하고 있다
	kotlin("kapt") version "1.3.61" // querydsl 추가
//	idea
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

	kapt("org.springframework.boot:spring-boot-configuration-processor")
	// querydsl 추가 end ---

	runtimeOnly("com.h2database:h2")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

// querydsl 추가 start ---
//kotlin.sourceSets.main {
//	setBuildDir("$buildDir")
//}

sourceSets["main"].withConvention(org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet::class) {
	kotlin.srcDir("$buildDir/generated/source/kapt/main")
}

//idea {
//	module {
//		val kaptMain = file("build/generated/source/kapt/main")
//		sourceDirs.add(kaptMain)
//		generatedSourceDirs.add(kaptMain)
//	}
//}
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
