package Predavanje01

fun main() {
    playGame()
}

object Player {
    var points: Int = 0
    var card: Card? = null
}
object Computer {
    var points: Int = 0
    var card: Card? = null
}

fun playGame() {
    val hand = Deck()
    hand.shuffle()
    repeat(26){
        Player.card = hand.dealCard()
        Computer.card = hand.dealCard()

        print("${Player.card?.color} ${Player.card?.value}")
        print(" vs ")
        print("${Computer.card?.color} ${Computer.card?.value}")
        println()
        if(Player.card?.value?.value!! > Computer.card?.value?.value!!) {
            Player.points++
        } else if (Player.card?.value?.value!! < Computer.card?.value?.value!!){
            Computer.points++
        }
        println("Current score: Player - ${Player.points} : Computer - ${Computer.points}")
        print("Press enter to continue")
        readln()
        println()
    }

    if (Player.points > Computer.points) {
        println("Player wins")
    } else if (Player.points < Computer.points){
        println("Computer wins")
    } else {
        println("Draw")
    }
}

enum class CardColor(var color: String) {
    CLUBS("green"),
    DIAMONDS("blue"),
    HEARTS("red"),
    SPADES("black")
}

enum class CardValue(var value: Int) {
    ACE(14),
    KING(13),
    QUEEN(12),
    JACK(11),
    TEN(10),
    NINE(9),
    EIGHT(8),
    SEVEN(7),
    SIX(6),
    FIVE(5),
    FOUR(4),
    THREE(3),
    TWO(2)
}

class Card(var color: CardColor, var value: CardValue) {

}

class Deck {
    var deck = arrayOfNulls<Card>(52)
    var count = 0
    init {
        var count = 0
        CardColor.entries.forEach{color ->
            CardValue.entries.forEach{value ->
                deck.set(count, Card(color, value))
                count++
            }
        }
    }

    fun shuffle() {
        deck.shuffle()
    }

    fun dealCard(): Card?{
        val card = deck[count]
        count++
        return card
    }
}