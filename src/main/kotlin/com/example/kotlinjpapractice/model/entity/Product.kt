package com.example.kotlinjpapractice.model.entity

import javax.persistence.*

@Entity
data class Product(
    var name: String,

    var price: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_mall_id", nullable = false)
    val shoppingMall: ShoppingMall,

    @OneToOne
    @JoinColumn(name = "thumbnail_image_id", nullable = false)
    val thumbnailImage: ProductImage,

    @OneToOne
    @JoinColumn(name = "product_detail_image_id", nullable = false)
    val productDetailImage: ProductImage


) : AutoEntity() {
}