package com.example.kotlinjpapractice.model.entity

import javax.persistence.*

@MappedSuperclass
abstract class AutoEntity : BaseEntity(){

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AutoEntity

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
//        return id?.hashCode() ?: 0
        return id.hashCode()
    }


}