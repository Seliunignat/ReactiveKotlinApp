package com.example.reactivekotlinapp.repository

import com.example.reactivekotlinapp.model.AppUser
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AppUserRepository : ReactiveCrudRepository<AppUser, Long>