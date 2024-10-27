package Predavanje01

fun main(){
    print("Low bound: ")
    val lowBound = readln().toInt()
    print("High bound: ")
    val highBound = readln().toInt()

    println("Unesi broj unutar granica $lowBound - $highBound ")
    var number: Int
    do {
        print("Unesi broj: ")
        number = readln().toInt()
        println("Unesen je broj $number")
    } while (number >= highBound || number <= lowBound)
}