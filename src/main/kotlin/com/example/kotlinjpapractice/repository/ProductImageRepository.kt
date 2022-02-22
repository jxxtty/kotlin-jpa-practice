package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.entity.ProductImage
import org.springframework.data.jpa.repository.JpaRepository

interface ProductImageRepository : JpaRepository<ProductImage, Long> {
}