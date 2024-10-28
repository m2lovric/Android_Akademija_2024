package Predavanje01

import java.nio.DoubleBuffer
import kotlin.math.sqrt

fun main() {
    val a = Dot()
    val b = Dot(23.0, 25.3)
    val c = Dot(23.0)

    println("x: ${a.x} y: ${a.y}")
    println("x: ${b.x} y: ${b.y}")
    println("x: ${c.x} y: ${c.y}")

    c.translate(2.0, 35.2)

    println("x: ${c.x} y: ${c.y}")

    println("Distance ${b.distanceFromPoint(2.5,1.0)}")

}

class Dot(var x: Double, var y: Double) {
    constructor(a: Double): this(a,a)
    constructor(): this(1.0, 2.0)

    fun translate(xtrans : Double, ytrans: Double) {
        x += xtrans
        y += ytrans
    }

    fun distanceFromPoint(x2: Double, y2: Double): Double {
        return sqrt(((x - x2) * (x - x2)) + ((y - y2) * (y - y2)))
    }
}