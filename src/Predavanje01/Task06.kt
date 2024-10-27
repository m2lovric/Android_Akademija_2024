package Predavanje01

fun main(){
println(powerOfNumber(2,3))
}

fun powerOfNumber(base : Int, exp: Int): Int {
    var number = base
    for (i in 1..< exp) {
        number *= base
    }

    return number
}