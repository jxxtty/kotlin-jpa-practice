package com.example.kotlinjpapractice.model.dto.order

import com.querydsl.core.annotations.QueryProjection

data class BizOrderListRes @QueryProjection constructor(
    val orderNum: String,
    val customerName: String,
    val orderStatus: String
)