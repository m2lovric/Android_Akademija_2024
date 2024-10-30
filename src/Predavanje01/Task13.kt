package Predavanje01

import kotlin.random.Random

fun main() {
    val hand = DiceHand()
    println("Start game ? y/n ")
    val input = readln().toCharArray()
    val startGame = input[0].lowercaseChar() == 'y' && input.size == 1

    if(startGame) {
        println("Game start")
        hand.rollDice()
        hand.printValues()
        repeat(2){
            println("Would you like to lock some dice ? y/n ")
            val decision = readln().toCharArray()[0].lowercaseChar()
            if(decision == 'y') {
                hand.lockDice()
            }

            hand.rollDice()
            hand.printValues()
        }
        println(hand.evaluateHand(hand.diceList))
    } else {
        println("GAME OVER")
    }

}

const val RESET = "\u001B[0m"
const val RED = "\u001B[31m"
const val GREEN = "\u001B[32m"

class Dice(var current: Int = 1) {
    var locked: Boolean = false
    fun roll() {
        val rand = (1..6).random()
        if (locked) {
            current
        } else {
            current = rand
        }
    }
}

class DiceHand {

    val diceList: List<Dice> = listOf(Dice(),Dice(),Dice(),Dice(),Dice(),Dice())

    fun rollDice() {
        diceList.forEach{ dice -> dice.roll() }
    }

//    fun rollUnlocked() {
//        diceList.forEach { dice -> if (!dice.locked) dice.roll() }
//    }

    fun lockDice() {
        println("Lock dice? (e.g. 1, 2, 4)")
        val input = readln()
        val locked = input.split(", ")
        diceList.forEachIndexed{index, dice ->
            locked.forEach{
                if(index + 1 == it.toInt()) {
                    dice.locked = true
                }
            }
        }
//        diceList.forEachIndexed{
//            index, dice ->
//            if(!dice.locked){
//                println("Lock dice ${index + 1} y/n: ")
//                val lock : Boolean = when (readln().toCharArray()[0].lowercaseChar()) {
//                    'y' -> {true}
//                    else -> {false}
//                }
//                dice.locked = lock
//            }
//        }

    }

    fun evaluateHand(hand: List<Dice>): String {
        return when {
            checkJamb(hand) -> "Jamb"
            checkPoker(hand) -> "Poker"
            checkStraight(hand) -> "Straight"
            else -> "You have nothing"
        }
    }

    private fun checkPoker(hand: List<Dice>): Boolean {
        var count = 0
        for(num in 1..6){
            hand.forEach{ dice ->
                if (dice.current == num) count++
            }
            if (count == 4) {
                return true
            } else {
                count = 0
            }
        }

        return false
    }

    private fun checkStraight(hand: List<Dice>): Boolean {
        var count = 0
        for(num in 1..6){
            hand.forEach{ dice ->
                if (dice.current == num) count++
            }
            if (count > 1) {
                return false
            } else {
                count = 0
            }
        }

        return true
    }

    private fun checkJamb(hand: List<Dice>): Boolean {
        var count = 0
        for(num in 1..6){
            hand.forEach{ dice ->
                if (dice.current == num) count++
            }
            if (count == 6) {
                return true
            } else {
                count = 0
            }
        }

        return false
    }

    fun printValues() {
        diceList.forEachIndexed{ index, dice ->
            if(dice.locked) {
                print("${RED}[Dice ${index + 1}] ${dice.current}${RESET} ")
            } else {
                print("${GREEN}[Dice ${index + 1}] ${dice.current}${RESET} ")
            }
        }
        println()
    }
}