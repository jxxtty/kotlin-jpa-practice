package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.entity.ProductOption
import org.springframework.data.jpa.repository.JpaRepository

interface ProductOptionRepository : JpaRepository<ProductOption, Long> {
}