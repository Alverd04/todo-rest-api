package com.example.todos_app

import com.example.todos_app.application.dto.TodoDto
import com.example.todos_app.application.service.TodoService
import com.example.todos_app.model.TodoEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/todos")
class TodoController(
   val todoService: TodoService
){

    @GetMapping
    fun getTodos(): ResponseEntity<List<TodoDto>> {
        val todos = todoService.getTodos().map {
            it -> TodoDto(it.id, it.title, it.description)
        }
        return ResponseEntity.ok(todos)
    }

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: Long): ResponseEntity<TodoDto> {
        val todo = todoService.getTodoById(id)
        if (todo.isPresent) {
            return ResponseEntity.ok(TodoDto(todo.get().id, todo.get().title, todo.get().description))
        }
        return ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createTodo(@RequestBody todoDto: TodoDto): ResponseEntity<TodoDto> {
        val todo = todoService.createTodo(todoDto.title, todoDto.description)
        return ResponseEntity.ok(TodoDto(todo.id, todo.title, todo.description))
    }

    @PutMapping("/{id}")
    fun updateTodo(
        @PathVariable id: Long,
        @RequestBody todoDto: TodoDto
    ): ResponseEntity<TodoDto> {
        todoService.updateTodo(
            todoDto.title,
            todoDto.description,
            id
        )
        return ResponseEntity.ok(todoDto)
    }

    @DeleteMapping("/{id}")
    fun deleteTodo(
        @PathVariable id: Long
    ): ResponseEntity<Unit> {
        todoService.deleteTodo()
        return ResponseEntity.noContent().build()
    }

}