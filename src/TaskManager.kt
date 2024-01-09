class TaskManager {
    private val tasks = mutableListOf<Task>()

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun getTasks(): List<Task> {
        return tasks
    }

    fun completeTask(id: Int) {
        tasks.find { it.id == id }?.isCompleted = true
    }

    fun deleteTask(id: Int) {
        tasks.removeIf { it.id == id }
    }
}