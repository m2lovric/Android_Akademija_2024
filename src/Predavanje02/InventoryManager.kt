package Predavanje02

import Predavanje02.Classes.*
import Predavanje02.Utils.LoginHelper
import Predavanje02.Utils.ProductCategory
import Predavanje02.Utils.Role
import Predavanje02.Utils.StockUpdate
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
        inventory.currentUser = currentUser
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

                if (inventory.currentUser.role == Role.ADMIN && inventory.currentUser is Admin) {
                    val adminUser = inventory.currentUser as Admin
                    adminUser.addEmployee(Employee.createEmployeeByRole(name, lastName, role))
                }
            }

            2 -> {
                println("Title: ")
                val title = readln()
                println("Category: 1. Food, 2. Tech, 3. Book")
                val category = readln().toInt()
                val productCategory = ProductCategory.entries.find { it.value == category }
                println("Quantity: ")
                val quantity = readln().toInt()
                if(title.isNotEmpty() && productCategory != null && quantity > 0)
                    inventory.addToInventory(Product(title, productCategory, quantity))
            }

            3 -> {
                println("Title: ")
                val title = readln()
                println("1. Increase product stock, 2. Decrease product stock")
                val action = readln().toInt()
                println("Quantity: ")
                val quantity = readln().toInt()
                if(title.isNotEmpty() && action in 1..2 && quantity > 0) {
                    when (action) {
                        1 -> inventory.updateStock(title, quantity, StockUpdate.ADD)
                        2 -> {
                            inventory.updateStock(title, quantity, StockUpdate.REMOVE)
                        }
                    }
                }
            }

            4 -> inventory.printAllProducts()
            5 -> exit = 5
            else -> {}
        }
    } while (exit != 5)
}