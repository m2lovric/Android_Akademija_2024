package Predavanje02

import kotlin.properties.Delegates

fun main() {
    println("Inventory management system")
    val inventory = Inventory()
    var exit = 0
    do {
        inventory.login("Admin")
        println(inventory.currentUser.name)
        println("Press number: 1. Add Employee, 2. Add Product, 3. Remove product, 4. Print all products 5. Exit")
        when (readln().toInt()) {
            1 -> {
                println("Enter name")
                val name = readln()
                println("Enter last name")
                val lastName = readln()
                println("Add role: 1. Admin, 2. Manager, 3. Worker")
                val roleValue = readln().toInt()
                val role = Role.entries.find { it.value == roleValue }
                inventory.currentUser.addEmployee(Employee(name, lastName, role!!))
            }
            2 -> {}
            3 -> {}
            4 -> inventory.allProducts()
            5 -> exit = 5
            else -> {}
        }
    } while (exit != 5)
}

enum class Role(var value: Int) {
    ADMIN(1), MANAGER(2), WORKER(3)
}

enum class ProductCategory(var value: Int) {
    FOOD(1), TECH(2), BOOK(3)
}

class Employee(val name: String, val lastName: String, val role: Role = Role.WORKER) {
    companion object {
        val employees = mutableListOf<Employee>(Employee("Admin", "Admin", Role.ADMIN))
    }

    fun addEmployee(employee: Employee) {
        if(this.role == Role.ADMIN) {
            employees.add(employee)
            println("Employee added successfully")
            employees.forEach{ println("${it.name} ${it.role}") }
        } else {
            throw IllegalAccessException("You don't have permission to add employee")
        }
    }
}

class Inventory() {
    private val inventory = mutableListOf<Product>()
    lateinit var currentUser: Employee
    fun addToInventory(product: Product) {
        inventory.add(product)
    }


    fun login(name: String): Boolean {
        val user = Employee.employees.find { it.name == name }
        if(user != null){
            currentUser = user
            return true
        } else {
            return false
        }
    }

    fun allProducts() {
        inventory.forEach{
            println(it)
        }
    }

}

class Product(val title: String, val category: ProductCategory, var stock: Int) {
    var lowStockAlert by Delegates.observable(stock) {_, _, new ->
        if(new < 5) println("LOW STOCK ALERT: Product: $title, stock: $stock")
    }

    fun addToStock(value: Int) {
        this.stock += value
    }

    fun removeFromStock(value: Int) {
        this.stock -= value
    }
}

