package com.example.kotlinjpapractice.model.entity

import javax.persistence.Entity

@Entity
data class BusinessUser(
    val loginId: String,
    var password: String,
    var username: String
) : AutoEntity() {
}