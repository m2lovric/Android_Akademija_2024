package Predavanje02

enum class Role(var value: Int) {
    ADMIN(1), MANAGER(2), WORKER(3)
}

enum class StockUpdate{
    ADD, REMOVE
}

enum class ProductCategory(var value: Int) {
    FOOD(1), TECH(2), BOOK(3)
}