package com.example.kotlinjpapractice.config

import com.querydsl.jpa.impl.JPAQueryFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.persistence.EntityManager
import javax.persistence.PersistenceContext

// jenkins 테스트를 위한 주석추가
// 2차 - jenkins 테스트


@Configuration
class QuerydslConfig(
    @PersistenceContext val entityManager: EntityManager
) {

    @Bean
    fun jpaQueryFactory() = JPAQueryFactory(entityManager)
}