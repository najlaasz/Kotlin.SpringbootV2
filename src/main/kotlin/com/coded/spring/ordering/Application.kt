package com.coded.spring.ordering

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@SpringBootApplication
@ComponentScan("com.example.authentication")

class Application{


	@Bean
	fun initUsers(userRepository: UsersRepository, passwordEncoder: PasswordEncoder) = CommandLineRunner {
		val user = UserEntity(
			name = "HelloUser",
			username = "testuser",
			password = passwordEncoder.encode("password123"),
			age = 18,
			role = Roles.USER
		)
		if (userRepository.findByUsername(user.username) == null) {
			println("Creating user ${user.username}")
			userRepository.save(user)
		} else  {
			println("User ${user.username} already exists")
		}
	}
}

fun main(args: Array<String>) {
	runApplication<Application>(*args)
}
