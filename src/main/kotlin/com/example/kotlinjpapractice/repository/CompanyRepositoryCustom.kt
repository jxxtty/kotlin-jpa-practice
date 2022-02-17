package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.dto.CompEmpRes

interface CompanyRepositoryCustom {
    fun findAllCompEmp(compId: Long): List<CompEmpRes>
}