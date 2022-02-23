package com.example.kotlinjpapractice.model.entity.enums

enum class OrderStatus(val statusInfo: String) {
    RECEIVE_ORDER("주문접수"),
    FINISH_SEND("발송완료"),
    FINISH_DELIVERY("배송완료"),
    CONFIRMED_PURCHASE("구매확정"),

    RECEIVE_CHANGE("교환접수"),
    FINISH_CHANGE("교환완료"),

    RECEIVE_REFUND("반품접수"),
    FINISH_REFUND("반품완료")
    ;

    companion object {
        fun valueOf(statusInfo: String) = OrderStatus.values().first { it.statusInfo == statusInfo }
    }

}