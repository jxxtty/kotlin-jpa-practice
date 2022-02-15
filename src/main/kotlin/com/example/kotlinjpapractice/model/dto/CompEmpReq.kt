package com.example.kotlinjpapractice.model.dto


data class CompEmpReq(
    var compName: String,
    var empNames: List<String>,
    var empDept: String
) {


}
