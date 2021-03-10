package machine

import java.util.*

/*
Stage 5/6: Keep track of the supplies
 */
val scanner = Scanner(System.`in`)

fun main() {
    val coffeMachine = CoffeMachine()

    while (true) {
        print("Write action (buy, fill, take, remaining, exit): ")
        val answer = scanner.next()
        println()
        when (answer) {
            "exit" -> break
            "remaining" -> coffeMachine.state.remaining()
            "take" -> coffeMachine.take()
            "fill" -> coffeMachine.fill()
            "buy" -> coffeMachine.buy()
        }
    }
}

class CoffeMachine {
    var money: Int = 550
    var water: Int = 400
    var milk: Int = 540
    var beans: Int = 120
    var disposableCups = 9

    val state: State = State(this)

    fun take() {
        println("I gave you ${money}")
        money -= money
        println()
    }

    fun fill() {
        print("Write how many ml of water do you want to add: ")
        val addWwater = scanner.nextInt()
        print("Write how many ml of milk do you want to add: ")
        val addMmilk = scanner.nextInt()
        print("Write how many grams of coffee beans do you want to add: ")
        val addBeans = scanner.nextInt()
        print("Write how many disposable cups of coffee do you want to add: ")
        val addDisposableCups = scanner.nextInt()

        water += addWwater
        milk += addMmilk
        beans += addBeans
        disposableCups += addDisposableCups
        println()
    }

    fun buy() {
        print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ")
        val n = scanner.next()
        makeCoffee(n)
    }

    fun makeCoffee(whatCoffee: String) {
        if (state.isReady(whatCoffee)) {
            println("I have enough resources, making you a coffee!\n")
            brew()
        } else if(whatCoffee != "back") {
            print("Sorry, not enough ")
            if (water < state.preparedWater) println("water!")
            if (milk < state.preparedMilk) println("milk!")
            if (beans < state.preparedBeans) println("coffee beans!")
            if (disposableCups < 0) println("disposable cups!")
        }
        println()
    }

    fun brew() {
        water -= state.preparedWater
        milk -= state.preparedMilk
        beans -= state.preparedBeans
        money += state.preparedMoney
        disposableCups--
    }
}

class State(val coffeMachine: CoffeMachine) {
    var preparedWater: Int = 0
    var preparedMilk: Int = 0
    var preparedBeans: Int = 0
    var preparedMoney: Int = 0

    fun remaining() {
        println("The coffee machine has:\n" +
                "${coffeMachine.water} of water\n" +
                "${coffeMachine.milk}  of milk\n" +
                "${coffeMachine.beans}  of coffee beans\n" +
                "${coffeMachine.disposableCups}  of disposable cups\n" +
                "${coffeMachine.money} of money\n")
    }

    fun isReady(whatCoffee: String): Boolean {
        when (whatCoffee) {
            "1" -> {
                preparedWater = 250
                preparedMilk = 0
                preparedBeans = 16
                preparedMoney = 4

            }
            "2" -> {
                preparedWater = 350
                preparedMilk = 75
                preparedBeans = 20
                preparedMoney = 7
            }
            "3" -> {
                preparedWater = 200
                preparedMilk = 100
                preparedBeans = 12
                preparedMoney = 6
            }
            else -> return false
        }
        return coffeMachine.water >= preparedWater &&
                coffeMachine.milk >= preparedMilk &&
                coffeMachine.beans >= preparedBeans &&
                coffeMachine.disposableCups > 0
    }
}
