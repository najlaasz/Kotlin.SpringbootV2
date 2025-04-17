package com.coded.spring.ordering

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloWorld {

    @GetMapping("/Hello")
    fun sayingHello(): String{
        return "Hello World ,, najla"
    }
}