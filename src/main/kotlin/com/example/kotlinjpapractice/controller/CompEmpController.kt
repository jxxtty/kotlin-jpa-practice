package com.example.kotlinjpapractice.controller

import com.example.kotlinjpapractice.model.dto.CompEmpReq
import com.example.kotlinjpapractice.model.dto.EmpDeptReq
import com.example.kotlinjpapractice.service.CompEmpService
import com.example.kotlinjpapractice.service.TestService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class CompEmpController(val compEmpService: CompEmpService,
                    val testService: TestService) {

    @PostMapping("/emp")
    fun saveNewCompAndEmp(@RequestBody compEmpReq: CompEmpReq): ResponseEntity<String> {
        compEmpService.saveCompAndEmp(compEmpReq.compName, compEmpReq.empNames, compEmpReq.empDept)
        return ResponseEntity.ok().body("make new Company and Employees")
    }

    @GetMapping("/call")
    fun printDiInfo(): ResponseEntity<String> {
        val result1 = compEmpService.callDIInfo()
        val result2 = testService.callDIInfo()

        return ResponseEntity.ok().body(result1 + " " + result2)
    }

    @PatchMapping("/emp")
    fun updateEmpDepartment(@RequestBody empDeptReq: EmpDeptReq): ResponseEntity<String> {
        if(!compEmpService.existId(empDeptReq.empId)) throw Exception("not exist Emp Id")

        compEmpService.updateEmpDepartment(empDeptReq.empId, empDeptReq.department)
        return ResponseEntity.ok().body("change emp ${empDeptReq.empId}'s department to ${empDeptReq.department}")
    }

    @GetMapping("/emp/{companyName}")
    fun findAllCompEmp(@PathVariable companyName: String): ResponseEntity<Any> {
        val list = compEmpService.findCompanyByName(companyName).let {
            if (it == null) return ResponseEntity.badRequest().body("not exist Company")
            else compEmpService.findAllCompEmp(it?.id!!)
        }

        return ResponseEntity.ok(list)
    }
}