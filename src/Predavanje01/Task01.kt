package Predavanje01

import java.time.LocalDate
fun main() {
    val birthYear = 1993
    val age = LocalDate.now().year - birthYear
    val ageAt2048 = 2048 - birthYear
    println(age)
    println(ageAt2048)

}