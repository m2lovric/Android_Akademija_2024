package Predavanje02.Utils

enum class Role {
    ADMIN, MANAGER, WORKER
}

enum class StockUpdate{
    ADD, REMOVE
}

enum class ProductCategory(var value: Int) {
    FOOD(1), TECH(2), BOOK(3)
}