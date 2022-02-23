package com.example.kotlinjpapractice.model.entity

import javax.persistence.Entity

@Entity
data class CustomerUser(
    val loginId: String,
    var password: String,
    var username: String,
    var address: String,
    var phoneNumber: String
) : AutoEntity() {
}