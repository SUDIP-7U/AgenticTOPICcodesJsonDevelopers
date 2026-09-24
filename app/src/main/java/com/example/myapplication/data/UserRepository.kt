package com.example.myapplication.data

import com.example.myapplication.domain.User

class UserRepository {
    fun getUser(): User {
        return User(
            id = "1",
            name = "John Doe",
            email = "john.doe@example.com",
        )
    }
}
