package Predavanje02.Classes

import Predavanje02.Role

class Manager(name: String, lastName: String, role: Role): Employee(name, lastName, role) {

    fun delegateJobToWorker(worker: Worker, stockUpdate: () -> Boolean) {
        val jobDone = worker.executeTask(stockUpdate)
        if (jobDone) worker.finishedTasks += 1
    }
}