package com.coded.spring.ordering

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository: JpaRepository<UserEntity,Int>{
    fun findByUsername(username: String): UserEntity?
}

@Entity
@Table(name = "users")
data class UserEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int? = null ,
    var name: String,
    var age: Int,
    var username: String,
    var password: String,
    @Enumerated(EnumType.STRING)
    val role: Roles = Roles.USER) {
    constructor() : this(0, "name", 0, "username", "password", Roles.USER)
}

enum class Roles{
    USER,ADMIN
}