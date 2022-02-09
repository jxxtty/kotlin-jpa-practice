package com.example.kotlinjpapractice.model.entity

import javax.persistence.*

@Entity
class Employee (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    var id: Long? = null,

    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    var company: Company?
 ){


}