package com.example.kotlinjpapractice.controller

import com.example.kotlinjpapractice.model.dto.order.OrderDeliveryReq
import com.example.kotlinjpapractice.model.entity.OrderDelivery
import com.example.kotlinjpapractice.model.entity.ProductOrderDelivery
import com.example.kotlinjpapractice.model.entity.enums.OrderStatus
import com.example.kotlinjpapractice.service.OrderDeliveryService
import com.example.kotlinjpapractice.service.ProductService
import com.example.kotlinjpapractice.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.lang.StringBuilder
import java.time.LocalDateTime

@RestController
class OrderDeliveryController(
    val orderDeliveryService: OrderDeliveryService,
    val userService: UserService,
    val productService: ProductService
) {

    @PostMapping("/order")
    fun createNewOrder(@RequestBody orderDeliveryReq: OrderDeliveryReq): ResponseEntity<String> {
        // customer 계정 조회
        if(!userService.existsCustomerUserId(orderDeliveryReq.userId)) return ResponseEntity.badRequest().body("사용자 계정을 찾을 수 없습니다.")
        val findCustomerUser = userService.findByIdReturnCustomerUser(orderDeliveryReq.userId)

        // order delivery 생성
        val newOrder = OrderDelivery(
            orderNum = "123456789",
            orderStatus = OrderStatus.RECEIVE_ORDER,
            customerUser = findCustomerUser
        )
        orderDeliveryService.createOrder(newOrder) // TODO : forEach문 분기처리에 걸리면 롤백해야함

        // product order delivery 생성
        orderDeliveryReq.orderList.forEach {
            if(!productService.existsById(it.productId)) return ResponseEntity.badRequest().body("주문한 상품을 찾을 수 없습니다.")
            val findProduct = productService.findByIdReturnProduct(it.productId)

            val findSizeOption = productService.findByIdReturnProductOption(it.optionSizeId)
            val findColorOption = productService.findByIdReturnProductOption(it.optionColorId)
            if(findColorOption.product != findProduct || findSizeOption.product != findProduct) return ResponseEntity.badRequest().body("상품의 옵션정보가 상품과 일치하지 않습니다.")

            val newProductOrderDelivery = ProductOrderDelivery(
                findProduct,
                newOrder,
                it.orderAmount,
                LocalDateTime.now(),
                findSizeOption,
                findColorOption
            )

            orderDeliveryService.createProductOrderDelivery(newProductOrderDelivery)
        }

        return ResponseEntity.ok().body("주문 생성 완료")
    }
}