package com.example.kotlinjpapractice.model.entity

import javax.persistence.*

/**
 * 모든 엔티티마다 id가 포함되고, 해당 id값으로 equals와 hashCode를 재정의하는 코드까지 작성해야한다.
 * 따라서 AutoEntity로 id를 분리하여 코드의 중복을 줄인다.
 */

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