package com.example.kotlinjpapractice.service

import com.example.kotlinjpapractice.model.entity.Company
import com.example.kotlinjpapractice.model.entity.Employee
import com.example.kotlinjpapractice.repository.CompanyRepository
import com.example.kotlinjpapractice.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class CompEmpService(
    private val companyRepository: CompanyRepository,
    private val employeeRepository: EmployeeRepository
) {

    fun saveCompAndEmp(compName: String, empNames: List<String>) {

        var newComp = Company(name = compName)
        companyRepository.save(newComp)

        empNames.forEach {
            var newEmp = Employee(name = it, company = newComp)
            employeeRepository.save(newEmp)
        }

    }
}