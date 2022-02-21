package com.example.kotlinjpapractice.controller

import com.example.kotlinjpapractice.model.dto.businessUser.BizUserReq
import com.example.kotlinjpapractice.model.entity.BusinessUser
import com.example.kotlinjpapractice.service.BusinessUserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class BusinessUserController(val businessUserService: BusinessUserService) {


    @PostMapping("/biz-user")
    fun createNewBusinessUser(@RequestBody bizUserReq: BizUserReq): ResponseEntity<String> {
        if(businessUserService.existLoginId(bizUserReq.loginId)) return ResponseEntity.badRequest().body("사용중인 아이디입니다.")

        val newBizUser = BusinessUser(bizUserReq.loginId, bizUserReq.password, bizUserReq.username)
        businessUserService.createNewBusinessUser(newBizUser)
        return ResponseEntity.ok().body("사업자 계정 생성 완료")
    }
}