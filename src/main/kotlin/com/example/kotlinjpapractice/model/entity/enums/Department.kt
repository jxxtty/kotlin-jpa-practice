package com.example.kotlinjpapractice.model.entity.enums

enum class Department(val deptName: String) {
    HR("인사팀"),
    SALES("영업팀"),
    DEVELOPMENT("개발팀"),
    MANAGEMENT_SUPPORT("경영지원팀");

    companion object {
        fun valueOf(deptName: String) = values().first { it.deptName == deptName }
    }
}