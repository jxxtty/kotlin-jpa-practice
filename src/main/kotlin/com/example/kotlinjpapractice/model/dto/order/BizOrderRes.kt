package com.example.kotlinjpapractice.model.dto.order

import com.querydsl.core.annotations.QueryProjection

data class BizOrderRes @QueryProjection constructor(
    val orderNum: String,
    val customerName: String,
    val customerLoginId: String,
    val orderStatus: String,
    val orderProductList: List<OrderProductListRes>
) {
}