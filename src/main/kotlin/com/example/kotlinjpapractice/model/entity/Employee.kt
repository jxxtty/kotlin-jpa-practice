package com.example.kotlinjpapractice.model.entity

import com.example.kotlinjpapractice.model.entity.enum.Department
import javax.persistence.*

@Entity
class Employee (
    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    var company: Company?,

    @Enumerated(EnumType.STRING)
    var department: Department
 ) : AutoEntity() {

     fun updateEmployee(empName: String, department: String) {
         this.name = empName
         this.department = Department.valueOf(department)
     }

    fun changeDepartment(department: String) {
        this.department = Department.valueOf(department)
    }
 }