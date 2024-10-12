package com.example.todos_app.application.service

import com.example.todos_app.model.TodoEntity
import com.example.todos_app.repository.TodoRepository
import org.springframework.stereotype.Service

@Service
class TodoService(
    private val todoRepository: TodoRepository
) {

    fun getTodos(): MutableList<TodoEntity> = todoRepository.findAll()

    fun getTodoById(id: Long) = todoRepository.findById(id)

    fun createTodo(
        title: String,
        description: String?
    ) = todoRepository.save(TodoEntity(title = title, description = description))

    fun updateTodo(
        title: String?,
        description: String?,
        id: Long
    ) {
        val todo = todoRepository.findById(id).get()
        val newTodo = todo.copy(
            title = title ?: todo.title,
            description = description ?: todo.description
        )
        todoRepository.save(newTodo)
    }

    fun deleteTodo() = todoRepository.deleteById(1)
}