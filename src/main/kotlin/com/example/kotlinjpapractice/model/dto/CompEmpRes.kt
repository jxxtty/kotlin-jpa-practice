package com.example.kotlinjpapractice.model.dto

import com.querydsl.core.annotations.QueryProjection

data class CompEmpRes @QueryProjection constructor(
    val compName: String,
    val empName: String,
    val deptName: String
) {
}