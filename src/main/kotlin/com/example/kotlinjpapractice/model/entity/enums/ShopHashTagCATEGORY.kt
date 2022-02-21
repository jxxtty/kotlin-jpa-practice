package com.example.kotlinjpapractice.model.entity.enums

enum class ShopHashTagCATEGORY(val hashtagInfo: String) {
    CLOTH("의류"),
    SHOES("슈즈"),
    BAG("가방"),
    INNER_WEAR("이너웨어"),
    JEWELRY("쥬얼리");

    companion object {
        fun valueOf(hashtagInfo: String) = ShopHashTagCATEGORY.values().first { it.hashtagInfo == hashtagInfo }
    }
}