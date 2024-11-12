package Predavanje02.Classes

import Predavanje02.Utils.ProductCategory
import Predavanje02.Utils.StockUpdate

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

    fun updateStock(title: String, quantity: Int, method: StockUpdate): Boolean {
        val index = inventory.indexOfFirst { it.title == title }
        if (method == StockUpdate.ADD) {
            inventory[index].stock += quantity
            return true
        } else if (method == StockUpdate.REMOVE){
            inventory[index].stock -= quantity
            return true
        } else return false
    }

    fun printAllProducts() {
        inventory.forEach {
            println("${it.title} ${it.category} ${it.stock}")
        }
    }
}

