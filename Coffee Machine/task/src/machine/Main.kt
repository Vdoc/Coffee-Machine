package machine

import java.util.*

/*
Stage 3/6: Estimate the number of servings
 */
val scanner = Scanner(System.`in`)

fun main() {
    val data = readInput()
    val coffeMachine = CoffeMachine(data)

    println("Write how many cups of coffee you will need: ")
    val n = scanner.nextInt()
    coffeMachine.makeCoffee(n)
}

class CoffeMachine {
    var water: Int
    var milk: Int
    var beans: Int
    var waterCups: Int
    var milkCups: Int
    var beansCups: Int


    constructor(data: Array<Int>) {
        water = data[0]
        milk = data[1]
        beans = data[2]
        waterCups = water / 200
        milkCups = milk / 50
        beansCups = beans / 15
    }

    fun makeCoffee(n: Int) {
        val min = min()
        if (min >= n) {
            print("Yes, I can make that amount of coffee")
            if (min > n) {
                print("(and even ${min - n} more than that)")
            }
            print("\n")
        } else {
            print("No, I can make only $min cups of coffee")
        }
        make(n)
    }

    private fun make(n: Int) {
        repeat(n){
            water -= 200
            milk -= 50
            beans -= 15
            waterCups--
            milkCups--
            beansCups--
        }
    }

    fun min(): Int {
        var min = waterCups
        if (milkCups < min) min = milkCups
        if (beansCups < min) min = beansCups
        return min
    }
}

fun readInput(): Array<Int> {
    println("Write how many ml of water the coffee machine has: ")
    val water = scanner.nextInt()
    println("Write how many ml of milk the coffee machine has: ")
    val milk = scanner.nextInt()
    println("Write how many grams of coffee beans the coffee machine has: ")
    val beans = scanner.nextInt()
    return arrayOf(water, milk, beans)
}



/*
Stage 2/6: Ingredient calculator

fun main() {
    println("Write how many cups of coffee you will need: ")
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    val water = 200 * n
    val milk = 50 * n
    val beans = 15 * n
    println("For $n cups of coffee you will need:\n" +
            "$water ml of water\n" +
            "$milk ml of milk\n" +
            "$beans g of coffee beans")
}
*/


/*
Stage 1/6: Making coffee
fun main() {
    println("Starting to make a coffee\n" +
            "Grinding coffee beans\n" +
            "Boiling water\n" +
            "Mixing boiled water with crushed coffee beans\n" +
            "Pouring coffee into the cup\n" +
            "Pouring some milk into the cup\n" +
            "Coffee is ready!")
}
*/