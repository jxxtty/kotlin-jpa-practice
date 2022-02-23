package com.example.kotlinjpapractice.model.dto.user

data class CustomerUserReq(
    var loginId: String,
    var password: String,
    var username: String,
    var address: String,
    var phoneNumber: String
)
