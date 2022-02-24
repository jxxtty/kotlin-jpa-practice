package com.example.kotlinjpapractice.model.dto.order

import com.querydsl.core.annotations.QueryProjection

data class OrderRes @QueryProjection constructor(
    val orderNum: String,
    val customerName: String,
    val customerLoginId: String,
    val orderStatus: String,
) {

    var orderProductList: List<OrderProductListRes> = emptyList()


    constructor(orderNum: String,
                customerName: String,
                customerLoginId: String,
                orderStatus: String,
                orderProductList: List<OrderProductListRes>) : this(orderNum, customerName, customerLoginId, orderStatus) {
                    this.orderProductList = orderProductList

    }
}
