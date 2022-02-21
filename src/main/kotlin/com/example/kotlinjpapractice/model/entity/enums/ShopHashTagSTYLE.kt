package com.example.kotlinjpapractice.model.entity.enums

enum class ShopHashTagSTYLE(val hashtagInfo: String) {
    CAMPUS("캠퍼스룩"),
    CASUAL("캐쥬얼"),
    SIMPLE_BASIC("심플베이직"),
    OFFICE("오피스룩");

    companion object {
        fun valueOf(hashtagInfo: String) = ShopHashTagSTYLE.values().first { it.hashtagInfo == hashtagInfo }
    }
}