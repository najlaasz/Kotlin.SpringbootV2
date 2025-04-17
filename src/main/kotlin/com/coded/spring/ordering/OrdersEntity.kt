package com.coded.spring.ordering

import jakarta.persistence.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrdersRepositry : JpaRepository<OrdersEntity,Int>
@Entity
@Table(name = "orders")
data class OrdersEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    var userId: Int,
    var resturant: String,
    var items: String
    ){
    constructor(): this (0,0,"","")

}