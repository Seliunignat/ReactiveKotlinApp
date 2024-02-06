package com.example.reactivekotlinapp.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table
data class AppUser(
    @Id val id: Long? = null,
    val name: String,
    val email: String
)
