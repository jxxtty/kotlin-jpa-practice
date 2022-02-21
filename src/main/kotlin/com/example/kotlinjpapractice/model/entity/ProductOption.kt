package com.example.kotlinjpapractice.model.entity

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.ManyToOne

@Entity
class ProductOption(
    var optionName: String,

    var addPrice: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    val product: Product
) : AutoEntity() {
}