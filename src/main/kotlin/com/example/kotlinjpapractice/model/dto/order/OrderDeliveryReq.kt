package com.example.kotlinjpapractice.model.dto.order

data class OrderDeliveryReq(
    var userId: Long, // customer user id
    var orderList: List<OrderListReq>

)
