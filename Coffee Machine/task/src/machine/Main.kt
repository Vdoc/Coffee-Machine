package machine

import java.util.*

/*
Stage 2/6: Ingredient calculator
 */
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