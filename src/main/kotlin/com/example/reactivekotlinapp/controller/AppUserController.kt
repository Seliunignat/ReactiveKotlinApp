package com.example.reactivekotlinapp.controller

import com.example.reactivekotlinapp.model.AppUser
import com.example.reactivekotlinapp.model.AppUserRequest
import com.example.reactivekotlinapp.service.AppUserService
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api")
class AppUserController(
    private val appUserService: AppUserService
) {
    @GetMapping("/users")
    fun getAll(): Flux<AppUser> =
        appUserService.findAll()

    @GetMapping("/users/{id}")
    fun getById(@PathVariable id: Long) =
        appUserService.findById(id)

    @PostMapping("/users")
    fun createUser(@RequestBody request: AppUserRequest): Mono<AppUser> =
        appUserService.createUser(request)
}