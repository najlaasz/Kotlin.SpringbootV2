package com.coded.spring.ordering

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class OnlineOrdering (val ordersRepositry: OrdersRepositry){



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

    @PostMapping("/orderDB")
    fun orderDB (@RequestBody newOrder: customerOrderDB){
        var theOrder= OrdersEntity()
        theOrder.userId = newOrder.userId
        theOrder.resturant = newOrder.resturant
        theOrder.items = newOrder.items
        ordersRepositry.save(theOrder)

    }

    @GetMapping("/orderDB")
    fun orderDB ():List<OrdersEntity>{
        var allOrderDB = OrdersEntity()
        return ordersRepositry.findAll()
    }
}


data class customerOrder(var user: String,var resturant: String , var items: List<String>)
data class customerOrderDB(var userId: Int,var resturant: String , var items: String)