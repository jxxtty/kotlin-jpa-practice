package com.example.kotlinjpapractice.service

import com.example.kotlinjpapractice.repository.CompanyRepository
import com.example.kotlinjpapractice.repository.EmployeeRepository
import com.example.kotlinjpapractice.repository.TestRepository
import org.springframework.stereotype.Service

@Service
class TestService(
    val companyRepository: CompanyRepository,
    val employeeRepository: EmployeeRepository
) {

    fun callDIInfo(): String {
        println(companyRepository.hashCode())
        println(employeeRepository.hashCode())

        val result = StringBuilder().append(companyRepository.hashCode()).append(" ").append(employeeRepository.hashCode())

        return result.toString()
    }

}