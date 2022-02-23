package com.example.kotlinjpapractice.service

import com.example.kotlinjpapractice.model.entity.Product
import com.example.kotlinjpapractice.model.entity.ProductImage
import com.example.kotlinjpapractice.model.entity.ProductOption
import com.example.kotlinjpapractice.repository.ProductImageRepository
import com.example.kotlinjpapractice.repository.ProductOptionRepository
import com.example.kotlinjpapractice.repository.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    val productRepository: ProductRepository,
    val productOptionRepository: ProductOptionRepository,
    val productImageRepository: ProductImageRepository
) {

    fun createProductImage(productImage: ProductImage) {
        productImageRepository.save(productImage)
    }

    fun createProductOption(productOption: ProductOption) {
        productOptionRepository.save(productOption)
    }

    fun createProduct(product: Product) {
        productRepository.save(product)
    }

    fun existsById(productId: Long): Boolean {
        return productRepository.existsById(productId)
    }

    fun findByIdReturnProduct(productId: Long): Product {
        return productRepository.findById(productId).get()
    }

    fun findByIdReturnProductOption(productOptionId: Long): ProductOption {
        return productOptionRepository.findById(productOptionId).get()
    }
}