package com.example.kotlinjpapractice.model.entity

import javax.persistence.*

@Entity
class Company (
    var name: String
    ) : AutoEntity() {

        fun updateCompany(compName: String) {
            this.name = compName
        }
}