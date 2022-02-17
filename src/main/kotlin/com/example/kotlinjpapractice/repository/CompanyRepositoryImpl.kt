package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.dto.CompEmpRes
import com.example.kotlinjpapractice.model.dto.QCompEmpRes
import com.example.kotlinjpapractice.model.entity.QCompany
import com.example.kotlinjpapractice.model.entity.QCompany.*
import com.example.kotlinjpapractice.model.entity.QEmployee
import com.example.kotlinjpapractice.model.entity.QEmployee.*
import com.querydsl.jpa.impl.JPAQueryFactory

class CompanyRepositoryImpl(val jpaQueryFactory: JPAQueryFactory) : CompanyRepositoryCustom{

    override fun findAllCompEmp(compId: Long): List<CompEmpRes> {
        return jpaQueryFactory.select(
            QCompEmpRes(
                company.name,
                employee.name
            )
        ).from(company)
            .leftJoin(employee).on(company.id.eq(employee.company.id))
            .where(company.id.eq(compId))
            .fetch()
    }
}