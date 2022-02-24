package com.example.kotlinjpapractice.model.dto.order

import com.querydsl.core.annotations.QueryProjection

data class OrderProductListRes @QueryProjection constructor(
    val thumbnailPath: String,
    val productName: String,
    val optionSize: String,
    val optionColor: String,
    val orderAmount: Int,
    val productPrice: Int
) {
}
