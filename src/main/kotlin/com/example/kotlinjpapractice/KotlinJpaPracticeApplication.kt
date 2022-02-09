package com.example.kotlinjpapractice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class KotlinJpaPracticeApplication

fun main(args: Array<String>) {
	runApplication<KotlinJpaPracticeApplication>(*args)
}
