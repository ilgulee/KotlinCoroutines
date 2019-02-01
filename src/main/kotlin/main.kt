import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) {
    exampleBlocking()
}

suspend fun printlnDelayed(message: String) {
    // Complex calculation
    delay(1000)
    println(message)
}

fun exampleBlocking(){
    println("one")
    runBlocking {
        printlnDelayed("two")
    }
    println("three")
}
