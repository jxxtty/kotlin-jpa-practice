package com.example.kotlinjpapractice.model.entity

import javax.persistence.*

@Entity
class Employee (
    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    var company: Company?
 ) : AutoEntity() {

     fun updateEmployee(empName: String) {
         this.name = empName
     }
 }