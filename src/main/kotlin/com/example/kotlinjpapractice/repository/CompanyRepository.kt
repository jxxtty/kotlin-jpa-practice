package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.entity.Company
import org.springframework.data.repository.CrudRepository

interface CompanyRepository : CrudRepository<Company, Long>, CompanyRepositoryCustom {

    fun findByName(name: String): Company?

    fun existsCompanyByName(name: String): Boolean
}