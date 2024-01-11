package org.example

data class Task(
    var id: Int,
    var name: String,
    var isCompleted: Boolean = false
)