package Predavanje02.Classes

import Predavanje02.Role

open class Employee(val name: String, val lastName: String, val role: Role = Role.WORKER) {
    companion object {
        fun createEmployeeByRole(name: String, lastName: String, role: Role): Employee {
            return when (role) {
                Role.WORKER -> Worker(name, lastName, role)
                Role.MANAGER -> Manager(name, lastName, role)
                Role.ADMIN -> Admin(name, lastName, role)
            }
        }
    }
}