package Predavanje02

import kotlin.properties.Delegates

fun main() {
    println("Manufacture")
}

enum class Role {
    ADMIN, MANAGER, WORKER
}

class Employee(val name: String, val lastName: String, val role: Role) {
    companion object {
        private val employees = mutableListOf<Employee>(Employee("Admin", "Admin", Role.ADMIN))
    }

    fun addEmployee(employee: Employee) {
        if(this.role == Role.ADMIN) {
            employees.add(employee)
            println("Employee added successfully")
        } else {
            throw IllegalAccessException("You don't have permission to add employee")
        }
    }

    fun login(name: String): Boolean {
        return employees.any { it.name == name }
    }
}

class Inventory() {
    private val inventory = mutableListOf<Product>()
    fun addToInventory(product: Product) {
        inventory.add(product)
    }
}

class Product(val title: String, val category: String, val stock: Int) {
    var lowStockAlert by Delegates.observable(stock) {_, _, new ->
        if(new < 5) println("LOW STOCK ALERT: Product: $title, stock: $stock")
    }
}

