package com.example.kotlinjpapractice.model.dto.order

import com.querydsl.core.annotations.QueryProjection

data class BizOrderDetailRes @QueryProjection constructor(
    val orderNum: String,

    val customerName: String,
    val customerLoginId: String,
    val customerAddress: String
) {
    var orderProductList: List<OrderProductListRes> = emptyList()
}
