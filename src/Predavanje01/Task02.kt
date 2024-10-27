package Predavanje01

fun main() {
    val numbers: MutableList<Int> = mutableListOf()
    repeat(3) {
        print("Unesi broj: ")
        val num = readln().toInt()
        numbers.add(num)
        println()
    }
    var max = 0
    for(num in numbers) {
        if (num > max) {
            max = num
        }
    }

    println(max)
}