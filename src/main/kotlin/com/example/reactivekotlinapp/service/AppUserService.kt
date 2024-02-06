package com.example.reactivekotlinapp.service

import BadRequestException
import NotFoundException
import com.example.reactivekotlinapp.model.AppUser
import com.example.reactivekotlinapp.model.AppUserRequest
import com.example.reactivekotlinapp.repository.AppUserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class AppUserService(
    private val appUserRepository: AppUserRepository
) {

    fun findAll(): Flux<AppUser> =
        appUserRepository.findAll()

    fun findById(id: Long): Mono<AppUser> =
        appUserRepository.findById(id)
            .switchIfEmpty(
                Mono.error(
                    NotFoundException("User with id $id was not found :(")
                )
            )

    fun createUser(appUserRequest: AppUserRequest): Mono<AppUser> {
        return appUserRepository.findByEmail(appUserRequest.email)
            .flatMap {
                Mono.error<AppUser>(
                    BadRequestException("User with email ${appUserRequest.email} already exists!")
                )
            }.switchIfEmpty(
                appUserRepository.save(
                    AppUser(
                        name = appUserRequest.name,
                        email = appUserRequest.email
                    )
                )
            )
    }

}