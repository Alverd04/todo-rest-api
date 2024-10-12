package com.example.todos_app.repository

import com.example.todos_app.model.TodoEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository: JpaRepository<TodoEntity, Long> {
    fun findByTitle(title: String): TodoEntity?
}