package com.example.kotlinjpapractice.model.dto.product

data class ProductReq(
    var shopId: Long,
    var name: String,
    var price: Int,
    var optionList: List<ProductOptionReq>,
    var thumbnailImageTitle: String,
    var thumbnailImagePath: String,
    var productDetailImageTitle: String,
    var productDetailImagePath: String

)
