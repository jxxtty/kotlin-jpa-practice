package com.example.kotlinjpapractice.model.entity.enums

enum class ShopHashTagAGE(val hashtagInfo: String) {
    TEENAGER("10대"),

    TWENTY_EARLY("20대 초반"),
    TWENTY_MID("20대 중반"),
    TWENTY_LATE("20대 후반"),

    THIRTY_EARLY("30대 초반"),
    THIRTY_MID("30대 중반"),
    THIRTY_LATE("30대 후반");

    companion object {
        fun valueOf(hashtagInfo: String) = ShopHashTagAGE.values().first { it.hashtagInfo == hashtagInfo }

    }
}