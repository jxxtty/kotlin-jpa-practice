package com.example.kotlinjpapractice.model.dto.order

data class OrderListReq(
    var productId: Long,
    var orderAmount: Int,
    var optionSizeId: Long,
    var optionColorId: Long
) {
}