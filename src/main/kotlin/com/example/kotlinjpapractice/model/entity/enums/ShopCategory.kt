package com.example.kotlinjpapractice.model.entity.enums

enum class ShopCategory(val categoryInfo: String) {
    MALE("남성복"),
    FEMALE("여성복"),
    CHILD("아동복");

    companion object {
        fun valueOf(categoryInfo: String) = ShopCategory.values().first { it.categoryInfo == categoryInfo }
    }
}