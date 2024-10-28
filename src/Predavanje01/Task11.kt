package Predavanje01

import kotlin.math.pow

fun main() {
    val smallCircle = Circle(5.0)
    println(smallCircle.circumference())
    println(smallCircle.area())
}

class Circle(private var radius: Double) {
    private val pi: Double = 3.14159

    fun circumference() = 2 * pi * radius
    fun area() = radius.pow(2) * pi
}