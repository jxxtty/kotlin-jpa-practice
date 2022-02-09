package com.example.kotlinjpapractice.controller

import com.example.kotlinjpapractice.model.dto.CompEmpReq
import com.example.kotlinjpapractice.service.CompEmpService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class CompEmpController(val compEmpService: CompEmpService) {

    @PostMapping("/new")
    fun saveNewCompAndEmp(@RequestBody compEmpReq: CompEmpReq): ResponseEntity<String> {
        compEmpService.saveCompAndEmp(compEmpReq.compName, compEmpReq.empNames)
        return ResponseEntity.ok().body("make new Company and Employees")
    }
}