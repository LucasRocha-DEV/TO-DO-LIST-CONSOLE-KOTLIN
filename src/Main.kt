fun main() {
    val taskManager = TaskManager()
    var continueLoop = true

    while (continueLoop) {
        println("1. Adicionar tarefa")
        println("2. Completar tarefa")
        println("3. Deletar tarefa")
        println("4. Ver todas as tarefas")
        println("5. Sair")

        when (readLine()) {
            "1" -> {
                println("Digite o ID da tarefa:")
                val id = readLine()?.toIntOrNull()
                println("Digite o nome da tarefa:")
                val name = readLine()
                if (id != null && name != null) {
                    taskManager.addTask(Task(id, name))
                } else {
                    println("ID inválido ou nome da tarefa.")
                }
            }
            "2" -> {
                println("Digite o ID da tarefa a ser concluída:")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    taskManager.completeTask(id)
                } else {
                    println("ID inválido.")
                }
            }
            "3" -> {
                println("Digite o ID da tarefa a ser deletada:")
                val id = readLine()?.toIntOrNull()
                if (id != null) {
                    taskManager.deleteTask(id)
                } else {
                    println("ID inválido.")
                }
            }
            "4" -> {
                println("Tarefas:")
                taskManager.getTasks().forEach {
                    println("ID: ${it.id}, Nome: ${it.name}, Concluída: ${it.isCompleted}")
                }
            }
            "5" -> {
                continueLoop = false
            }
            else -> {
                println("Opção inválida.")
            }
        }
    }
}