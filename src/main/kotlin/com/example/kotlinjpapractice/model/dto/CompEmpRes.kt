package com.example.kotlinjpapractice.model.dto

import com.example.kotlinjpapractice.model.entity.enum.Department
import com.querydsl.core.annotations.QueryProjection

data class CompEmpRes @QueryProjection constructor(
    val compName: String,
    val empName: String
) {
}