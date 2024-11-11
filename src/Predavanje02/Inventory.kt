package Predavanje02

import kotlin.system.exitProcess


fun main() {
    println("Inventory management system")
    val inventory = Inventory()
    val loginHelper = LoginHelper()
    var exit = 0
    println("Login name:")
    val username = readln()
    loginHelper.performLogin(
        username = username,
        onFailure = { exitProcess(0) }) { currentUser ->
        // Proceed with the program. The current user is available here if needed.
    }
    do {
        println(inventory.currentUser.name)
        println("Press number: 1. Add Employee, 2. Add Product, 3. Update Stock, 4. Print all products 5. Exit")
        when (readln().toInt()) {
            1 -> {
                println("Name: ")
                val name = readln()
                println("Last name: ")
                val lastName = readln()
                println(buildString {
                    Role.entries.forEachIndexed { index, role -> append("${index + 1}.$role ") }
                })
                val input = readln().toIntOrNull()
                val roleIndex = if (input == null || (input - 1) >= Role.entries.count()) {
                    println("Unsupported operation! Exiting app...")
                    exitProcess(0)
                } else {
                    input - 1
                }
                val role = Role.entries[roleIndex]
                inventory.currentUser.addEmployee(Employee(name, lastName, role))
            }

            2 -> {
                println("Title: ")
                val title = readln()
                println("Category: 1. Food, 2. Tech, 3. Book")
                val category = readln().toInt()
                val productCategory = ProductCategory.entries.find { it.value == category }
                println("Quantity: ")
                val quantity = readln().toInt()
                inventory.addToInventory(Product(title, productCategory!!, quantity))
            }

            3 -> {
                println("Title: ")
                val title = readln()
                println("1. Increase product stock, 2. Decrease product stock")
                val action = readln().toInt()
                println("Quantity: ")
                val quantity = readln().toInt()
                when (action) {
                    1 -> inventory.updateStock(title, quantity, StockUpdate.ADD)
                    2 -> {
                        inventory.updateStock(title, quantity, StockUpdate.REMOVE)
                    }
                }

            }

            4 -> inventory.printAllProducts()
            5 -> exit = 5
            else -> {}
        }
    } while (exit != 5)
}

fun login(employees: List<Employee>, name: String, inventory: Inventory): Boolean {
    val employee = employees.indexOfFirst { it.name == name }
    return if (employee != -1) {
        inventory.setUser(employees[employee])
        true
    } else {
        false
    }
}

class Inventory() {
    private val inventory = mutableListOf<Product>(Product("Orange", ProductCategory.FOOD, 12))
    lateinit var currentUser: Employee
    fun addToInventory(product: Product) {
        inventory.add(product)
    }

    fun setUser(user: Employee) {
        currentUser = user
    }

    fun getAllProducts(): MutableList<Product> {
        return inventory
    }

    fun updateStock(title: String, quantity: Int, method: StockUpdate) {
        val index = inventory.indexOfFirst { it.title == title }
        if (method.equals(StockUpdate.ADD)) {
            inventory[index].stock += quantity
        } else {
            inventory[index].removeFromStock(quantity)
        }
    }

    fun printAllProducts() {
        inventory.forEach {
            println("${it.title} ${it.category} ${it.stock}")
        }
    }
}

