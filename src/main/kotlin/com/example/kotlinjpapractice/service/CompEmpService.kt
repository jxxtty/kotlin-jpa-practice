package com.example.kotlinjpapractice.service

import com.example.kotlinjpapractice.model.dto.CompEmpRes
import com.example.kotlinjpapractice.model.entity.Company
import com.example.kotlinjpapractice.model.entity.Employee
import com.example.kotlinjpapractice.model.entity.enum.Department
import com.example.kotlinjpapractice.repository.CompanyRepository
import com.example.kotlinjpapractice.repository.EmployeeRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class CompEmpService(
    private val companyRepository: CompanyRepository,
    private val employeeRepository: EmployeeRepository
) {

    fun saveCompAndEmp(compName: String, empNames: List<String>, empDept: String) {

        var newComp = Company(compName)
        companyRepository.save(newComp)

        empNames.forEach {
            var newEmp = Employee(it, newComp, Department.valueOf(empDept))
            employeeRepository.save(newEmp)
        }

    }

    fun callDIInfo(): String {
        println(companyRepository.hashCode())
        println(employeeRepository.hashCode())

        val result = StringBuilder().append(companyRepository.hashCode()).append(" ").append(employeeRepository.hashCode())

        return result.toString()
    }

    fun existId(empId: Long): Boolean {
        return employeeRepository.existsById(empId)
    }

    @Transactional
    fun updateEmpDepartment(empId: Long, department: String) {
        employeeRepository.findById(empId).get().let {
            it.changeDepartment(department)
        }
    }

    fun existCompany(companyName: String): Boolean {
        return companyRepository.existsCompanyByName(companyName)
    }

    fun findCompanyByName(companyName: String): Company? {
        return companyRepository.findByName(companyName)
    }

    fun findAllCompEmp(compId: Long): List<CompEmpRes> {
        return companyRepository.findAllCompEmp(compId)
    }
}