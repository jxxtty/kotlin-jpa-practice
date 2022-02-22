package com.example.kotlinjpapractice.repository

import com.example.kotlinjpapractice.model.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>{
}