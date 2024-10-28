import Predavanje01.Dice
import Predavanje01.DiceHand
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class TestJamb {
    @Test
    fun testCheckNothing(){
        val hand = DiceHand()
        hand.diceList = listOf(
            Dice(1), Dice(2), Dice(3), Dice(3), Dice(4), Dice(2)
        )

        val result = hand.evaluateHand(hand.diceList)
        assertEquals("You have nothing", result)
    }

    @Test
    fun testCheckPoker(){
        val hand = DiceHand()
        hand.diceList = listOf(
            Dice(1), Dice(1), Dice(1), Dice(3), Dice(1), Dice(2)
        )

        val result = hand.evaluateHand(hand.diceList)
        assertEquals("Poker", result)
    }

    @Test
    fun testCheckStraight(){
        val hand = DiceHand()
        hand.diceList = listOf(
            Dice(1), Dice(2), Dice(4), Dice(3), Dice(6), Dice(5)
        )

        val result = hand.evaluateHand(hand.diceList)
        assertEquals("Straight", result)
    }

    @Test
    fun testCheckJamb(){
        val hand = DiceHand()
        hand.diceList = listOf(
            Dice(4), Dice(4), Dice(4), Dice(4), Dice(4), Dice(4)
        )

        val result = hand.evaluateHand(hand.diceList)
        assertEquals("Jamb", result)
    }
}

