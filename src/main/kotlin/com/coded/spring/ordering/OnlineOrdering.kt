package com.coded.spring.ordering

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OnlineOrdering {



//    var customerOrd://customerOrder("ali","pizza hut", listOf("pizza", "chicken wings" , "pepsi") )

    var customerOrdList = mutableListOf<customerOrder>()
    @PostMapping("/order")
    fun order(@RequestBody newOrder: customerOrder): String{
                customerOrdList.add(newOrder)
        return "your order submitted"
    }

    @GetMapping("/order")
    fun allOrder (): List<customerOrder>{
        return customerOrdList
    }
}


data class customerOrder(var user: String,var resturant: String , var items: List<String>)