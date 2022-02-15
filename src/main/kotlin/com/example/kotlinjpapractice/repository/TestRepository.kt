package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.entity.Test
import org.springframework.data.repository.CrudRepository

interface TestRepository : CrudRepository<Test, Long> {
}