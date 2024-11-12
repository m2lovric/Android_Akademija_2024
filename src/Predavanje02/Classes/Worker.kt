package Predavanje02.Classes

import Predavanje02.Role

class Worker(name: String, lastName: String, role: Role): Employee(name, lastName, role) {
    var finishedTasks = 0
    fun executeTask(updateStock: () -> Boolean): Boolean {
        val done = updateStock()
        return done
    }
}