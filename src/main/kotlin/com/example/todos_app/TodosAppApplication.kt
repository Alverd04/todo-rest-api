package com.example.todos_app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodosAppApplication

fun main(args: Array<String>) {
	runApplication<TodosAppApplication>(*args)
}
