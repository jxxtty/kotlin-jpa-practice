package com.example.kotlinjpapractice.model.entity.enums

enum class ProductCategory(val categoryInfo: String) {
    OUTER("아우터"),
    TOP("상의"),
    BOTTOM("하의"),
    ACC("가방, 악세사리"),
    SHOES("신발");

    companion object {
        fun valueOf(categoryInfo: String) = ProductCategory.values().first { it.categoryInfo == categoryInfo }
    }

}