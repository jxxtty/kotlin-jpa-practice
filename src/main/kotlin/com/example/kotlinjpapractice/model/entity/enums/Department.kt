package com.example.kotlinjpapractice.model.entity.enums

// enum 선언시 deptName이 사용되지않아 인식이 안됐던 것 같다.
// deptName을 사용해주니 employee qclass에서 department를 불러올수있었다.

enum class Department(val deptName: String) {
    HR("인사팀"),
    SALES("영업팀"),
    DEVELOPMENT("개발팀"),
    MANAGEMENT_SUPPORT("경영지원팀");

    companion object {
        fun valueOf(deptName: String) = values().first { it.deptName == deptName }
    }
}