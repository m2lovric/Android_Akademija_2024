package Predavanje01

fun main() {
    playGame()
}

class Player {
    var points: Int = 0
    var card: Card? = null

    fun compareCardTo(opponent: Player) {
        val myCard = this.card ?: return
        val opponentCard = opponent.card ?: return

        if(myCard.value.value > opponentCard.value.value) {
            this.points++
        } else if(myCard.value.value == opponentCard.value.value){
            return
        } else {
            opponent.points++
        }
    }
}

fun playGame() {
    val player = Player()
    val computer = Player()
    val hand = Deck()
    hand.shuffle()
    repeat(26){
        player.card = hand.dealCard()
        computer.card = hand.dealCard()

        val (colorPlayer, valuePlayer) = player.card!!
        val (colorComputer, valueComputer) = computer.card!!

        print("$colorPlayer $valuePlayer ")
        print(" vs ")
        print("$colorComputer $valueComputer")
        println()
        player.compareCardTo(computer)
//        if(valuePlayer.value > valueComputer.value) {
//            player.points++
//        } else if (valuePlayer.value < valueComputer.value){
//            computer.points++
//        }
        println("Current score: Player - ${player.points} : Computer - ${computer.points}")
        print("Press enter to continue")
        readln()
        println()
    }

    if (player.points > computer.points) {
        println("Player wins")
    } else if (player.points < computer.points){
        println("Computer wins")
    } else {
        println("Draw")
    }
}

enum class CardColor() {
    CLUBS,
    DIAMONDS,
    HEARTS,
    SPADES
}

enum class CardValue(val value: Int) {
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

data class Card(val color: CardColor, val value: CardValue) {

}

class Deck {
    private val deck = arrayOfNulls<Card>(52)
    private var count = 0
    init {
        var count = 0
        CardColor.entries.forEach{color ->
            CardValue.entries.forEach{value ->
                deck[count] = Card(color, value)
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