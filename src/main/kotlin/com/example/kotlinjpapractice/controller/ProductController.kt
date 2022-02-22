package com.example.kotlinjpapractice.controller

import com.example.kotlinjpapractice.model.dto.product.ProductReq
import com.example.kotlinjpapractice.model.entity.Product
import com.example.kotlinjpapractice.model.entity.ProductImage
import com.example.kotlinjpapractice.model.entity.ProductOption
import com.example.kotlinjpapractice.service.ProductService
import com.example.kotlinjpapractice.service.ShoppingMallService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductController(
    val productService: ProductService,
    val shoppingMallService: ShoppingMallService
){

    @PostMapping("/product")
    fun createNewProduct(@RequestBody productReq: ProductReq): ResponseEntity<String> {
        if(!shoppingMallService.existsById(productReq.shopId)) return ResponseEntity.badRequest().body("쇼핑몰을 찾을 수 없습니다.")

        val newThumbnail = ProductImage(productReq.thumbnailImageTitle, productReq.thumbnailImagePath)
        val newProductDetail = ProductImage(productReq.productDetailImageTitle, productReq.productDetailImagePath)
        val findShoppingMall = shoppingMallService.findByIdReturnEntity(productReq.shopId)

        val newProduct = Product(
            productReq.name,
            productReq.price,
            findShoppingMall,
            newThumbnail,
            newProductDetail
        )

        productService.createProduct(newProduct)

        productReq.optionList.forEach {
            productService.createProductOption(ProductOption(it.optionName, it.addPrice, newProduct))
        }

        return ResponseEntity.ok().body("상품 생성완료")
    }
}