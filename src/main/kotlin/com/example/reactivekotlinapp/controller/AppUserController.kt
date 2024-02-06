package com.example.reactivekotlinapp.controller

import com.example.reactivekotlinapp.model.AppUser
import com.example.reactivekotlinapp.service.AppUserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
@RequestMapping("/api")
class AppUserController(
    private val appUserService: AppUserService
) {
    @GetMapping("/users")
    fun get(@RequestParam(required = false) id: Long?): Flux<AppUser> {
        return if (id == null) {
            appUserService.findAll()
        } else {
            appUserService.findById(id).flux()
        }
    }
}