package com.example.reactivekotlinapp.service

import com.example.reactivekotlinapp.model.AppUser
import com.example.reactivekotlinapp.repository.AppUserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class AppUserService(
    private val appUserRepository: AppUserRepository
) {

    fun findAll(): Flux<AppUser> =
        appUserRepository.findAll()
}