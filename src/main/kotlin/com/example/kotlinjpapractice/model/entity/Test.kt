package com.example.kotlinjpapractice.model.entity

import javax.persistence.Entity

@Entity
class Test(
    var test: String
) : AutoEntity() {
}