package Predavanje02

import kotlin.properties.Delegates

class Product(val title: String, val category: ProductCategory, stockInit: Int) {
    var stock: Int by Delegates.observable(stockInit) {_, _, new ->
        if(new < 5) println("LOW STOCK ALERT: Product: $title, stock: $stock")
    }

    fun addToStock(value: Int) {
        this.stock += value
    }

    fun removeFromStock(value: Int) {
        this.stock -= value
    }
}
