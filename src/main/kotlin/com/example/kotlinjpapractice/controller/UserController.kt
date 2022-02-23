package com.example.kotlinjpapractice.controller

import com.example.kotlinjpapractice.model.dto.user.BizUserReq
import com.example.kotlinjpapractice.model.dto.user.CustomerUserReq
import com.example.kotlinjpapractice.model.entity.BusinessUser
import com.example.kotlinjpapractice.model.entity.CustomerUser
import com.example.kotlinjpapractice.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(val userService: UserService) {


    @PostMapping("/biz-user")
    fun createNewBusinessUser(@RequestBody bizUserReq: BizUserReq): ResponseEntity<String> {
        if(userService.existsBizLoginId(bizUserReq.loginId)) return ResponseEntity.badRequest().body("사용중인 아이디입니다.")

        val newBizUser = BusinessUser(bizUserReq.loginId, bizUserReq.password, bizUserReq.username)
        userService.createNewBusinessUser(newBizUser)
        return ResponseEntity.ok().body("사업자 계정 생성 완료")
    }

    @PostMapping("/customer-user")
    fun createNewCustomerUser(@RequestBody customerUserReq: CustomerUserReq): ResponseEntity<String> {
        if(userService.existsCustomerLoginId(customerUserReq.loginId)) return ResponseEntity.badRequest().body("사용중인 아이디입니다.")

        val newCustomerUser = CustomerUser(
            customerUserReq.loginId,
            customerUserReq.password,
            customerUserReq.username,
            customerUserReq.address,
            customerUserReq.phoneNumber
        )

        userService.createNewCustomerUser(newCustomerUser)

        return ResponseEntity.ok().body("고객 계정 생성 완료")
    }
}