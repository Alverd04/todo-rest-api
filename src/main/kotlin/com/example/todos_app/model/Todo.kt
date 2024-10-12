package com.example.todos_app.model


import jakarta.persistence.*

@Entity
@Table(name = "todos")
data class TodoEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val title: String,
    val description: String?
)