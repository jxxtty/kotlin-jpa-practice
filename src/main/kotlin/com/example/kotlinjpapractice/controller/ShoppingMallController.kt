package com.example.kotlinjpapractice.controller

import com.example.kotlinjpapractice.model.dto.shoppingmall.ShoppingMallReq
import com.example.kotlinjpapractice.model.entity.ShoppingMall
import com.example.kotlinjpapractice.model.entity.enums.ShopCategory
import com.example.kotlinjpapractice.model.entity.enums.ShopHashTagAGE
import com.example.kotlinjpapractice.model.entity.enums.ShopHashTagCATEGORY
import com.example.kotlinjpapractice.model.entity.enums.ShopHashTagSTYLE
import com.example.kotlinjpapractice.service.BusinessUserService
import com.example.kotlinjpapractice.service.ShoppingMallService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ShoppingMallController(
    val shoppingMallService: ShoppingMallService,
    val businessUserService: BusinessUserService
    ) {

    @PostMapping("/shop")
    fun createNewShoppingMall(@RequestBody shoppingMallReq: ShoppingMallReq): ResponseEntity<String> {
        // 들어온 사업자계정 id 확인
        if(!businessUserService.existUserId(shoppingMallReq.userId)) return ResponseEntity.badRequest().body("사용자 계정을 찾을 수 없습니다.")

        val findBizUser = businessUserService.findByIdReturnEntity(shoppingMallReq.userId)

        println(">>>>>>> ${ShopHashTagSTYLE.valueOf(shoppingMallReq.hashTagSTYLE)}")
        //println(">>>>>>> ${ShopHashTagSTYLE.valueOf("캠퍼스룩")}")
//        println(">>>>>>> ${ShopHashTagSTYLE.valueOf(shoppingMallReq.hashTagCATEGORY)}")

        val newShoppingMall = ShoppingMall(
            findBizUser,
            ShopCategory.valueOf(shoppingMallReq.shopCategory),
            shoppingMallReq.shopName,
            ShopHashTagSTYLE.valueOf(shoppingMallReq.hashTagSTYLE),
            ShopHashTagAGE.valueOf(shoppingMallReq.hashTagAGE),
            ShopHashTagCATEGORY.valueOf(shoppingMallReq.hashTagCATEGORY)
        )

        shoppingMallService.createShoppingMall(newShoppingMall)

        return ResponseEntity.ok().body("쇼핑몰 생성 완료")
    }

}