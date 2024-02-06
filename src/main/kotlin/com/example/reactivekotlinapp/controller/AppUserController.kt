package com.example.reactivekotlinapp.controller

import com.example.reactivekotlinapp.model.AppUser
import com.example.reactivekotlinapp.service.AppUserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

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
}