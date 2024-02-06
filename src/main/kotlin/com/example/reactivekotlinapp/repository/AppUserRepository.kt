package com.example.reactivekotlinapp.repository

import com.example.reactivekotlinapp.model.AppUser
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Mono

interface AppUserRepository : ReactiveCrudRepository<AppUser, Long> {
    fun findByEmail(email: String): Mono<AppUser>
}