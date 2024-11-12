package Predavanje02.Classes

import Predavanje02.Role

class Admin(name: String, lastName: String, role: Role): Employee(name, lastName, role) {
    companion object{
        private val employees = mutableListOf<Employee>(
            Admin("Admin", "Admin", Role.ADMIN),
            Manager("Joe", "Manager", Role.MANAGER),
            Worker("Matteo", "Radnik", Role.WORKER)
        )
        fun getEmployees(): List<Employee> = employees
    }

    fun addEmployee(employee: Employee) {
        employees.add(employee)
        println("Employee added successfully")
        employees.forEach{ println("${it.name} ${it.role}") }
    }


}