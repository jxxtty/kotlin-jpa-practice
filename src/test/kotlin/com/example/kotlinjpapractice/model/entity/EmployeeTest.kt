package com.example.kotlinjpapractice.model.entity

import com.example.kotlinjpapractice.repository.CompanyRepository
import com.example.kotlinjpapractice.repository.EmployeeRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.context.TestConstructor
import javax.transaction.Transactional

@SpringBootTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class EmployeeTest(val employeeRepository: EmployeeRepository, val companyRepository: CompanyRepository) {

    @Transactional
    @Test
    internal fun `findById - lazy loading`() {

        println("employee 조회 전")
        val employee = employeeRepository.findByIdOrNull(1L)
        println("employee 조회 후 employee 내용에 접근 : ${employee?.name}")
        assertEquals(employee!!.name, "one")

        println("company 데이터에 접근 전")
        assertEquals(employee.company!!.name, "company name test")
        println("company 데이터에 접근 후--")

    }
}