package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.entity.Employee
import org.springframework.data.jpa.repository.JpaRepository

interface EmployeeRepository : JpaRepository<Employee, Long> {
}