package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.entity.Company
import org.springframework.data.repository.CrudRepository

interface CompanyRepository : CrudRepository<Company, Long> {

    fun findByName(name: String): Company?
}