package com.example.kotlinjpapractice.model.entity

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity
data class BusinessUser(
    val loginId: String,
    var password: String,
    var username: String,

    @OneToOne
    @JoinColumn(name = "shopping_mall_id")
    val shoppingMall: ShoppingMall
) : AutoEntity() {
}