package Predavanje01

fun main() {
    print("Unesi znak: ")
    val character = readln().trim()[0]
    val vowels = setOf('a', 'e', 'i', 'o', 'u')
    val isVowel = when {
        vowels.contains(character) -> true
        else -> false
    }

    when {
        isVowel -> println("Samoglasnik")
        else -> println("suglasnik")
    }
}