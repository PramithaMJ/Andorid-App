package com.example.viewmodelsscopedemo.model

import kotlinx.coroutines.delay

class UserRepository {
    suspend fun getUsers(): List<User> {
        delay(8000)
        val users: List<User> = listOf(
            User(1, "Sam"),
            User(2, "John"),
            User(3, "Mike"),
            User(4, "Ravi"),
            User(5, "Raj"),
        )
        return users
    }
}