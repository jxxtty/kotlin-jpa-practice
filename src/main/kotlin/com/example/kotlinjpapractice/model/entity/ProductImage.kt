package com.example.kotlinjpapractice.model.entity

import javax.persistence.Entity

@Entity
data class ProductImage(
    val title: String,
    val path: String
) : AutoEntity() {
}