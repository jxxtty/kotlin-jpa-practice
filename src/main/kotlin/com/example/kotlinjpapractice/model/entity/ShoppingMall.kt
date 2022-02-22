package com.example.kotlinjpapractice.model.entity

import com.example.kotlinjpapractice.model.entity.enums.ShopCategory
import com.example.kotlinjpapractice.model.entity.enums.ShopHashTagAGE
import com.example.kotlinjpapractice.model.entity.enums.ShopHashTagCATEGORY
import com.example.kotlinjpapractice.model.entity.enums.ShopHashTagSTYLE
import javax.persistence.*

@Entity
data class ShoppingMall(

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "business_user_id")
    val businessUser: BusinessUser,

    @Enumerated(EnumType.STRING)
    val shopCategory: ShopCategory,

    val shopName: String,

    @Enumerated(EnumType.STRING)
    val hashTagSTYLE: ShopHashTagSTYLE,

    @Enumerated(EnumType.STRING)
    val hashTagAGE: ShopHashTagAGE,

    @Enumerated(EnumType.STRING)
    val hashTagCATEGORY: ShopHashTagCATEGORY

) : AutoEntity() {
}