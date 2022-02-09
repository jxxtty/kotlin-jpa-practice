package com.example.kotlinjpapractice.model.entity

import javax.persistence.*

@Entity
class Company (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    var id: Long? = null,

    var name: String
    ) {


}