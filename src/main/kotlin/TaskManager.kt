package org.example

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class TaskManager {
    private val gson = Gson()
    private val taskType = object : TypeToken<List<Task>>() {}.type
    private val tasksFile = File("tasks.json")

    fun addTask(task: Task) {
        val tasks = getTasks().toMutableList()
        tasks.add(task)
        saveTasks(tasks)
    }

    fun getTasks(): List<Task> {
        return if (tasksFile.exists()) {
            val json = tasksFile.readText()
            gson.fromJson(json, taskType)
        } else {
            emptyList()
        }
    }

    fun completeTask(id: Int) {
        val tasks = getTasks().map {
            if (it.id == id) it.copy(isCompleted = true) else it
        }
        saveTasks(tasks)
    }

    fun deleteTask(id: Int) {
        val tasks = getTasks().filter { it.id != id }
        saveTasks(tasks)
    }

    private fun saveTasks(tasks: List<Task>) {
        val json = gson.toJson(tasks)
        tasksFile.writeText(json)
    }
}