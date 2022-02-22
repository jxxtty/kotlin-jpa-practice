package com.example.kotlinjpapractice.model.dto.shoppingmall

import com.example.kotlinjpapractice.model.entity.enums.ShopHashTagAGE
import com.example.kotlinjpapractice.model.entity.enums.ShopHashTagCATEGORY

data class ShoppingMallReq(
    var userId: Long,
    var shopCategory: String,
    var shopName: String,
    var hashTagSTYLE: String,
    var hashTagAGE: String,
    var hashTagCATEGORY: String
)
