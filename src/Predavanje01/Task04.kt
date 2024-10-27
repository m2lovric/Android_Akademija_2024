package Predavanje01

fun main(){
    print("Unesi prirodan broj: ")
    val num = readln().toInt()
    var total: Int = 0
    for (n in 1..num) {
        total += n
    }
    println(total)
}