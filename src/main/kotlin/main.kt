fun main(args: Array<String>) {
    exampleBlocking()
}

fun printlnDelayed(message: String) {
    // Complex calculation
    Thread.sleep(1000)
    println(message)
}

fun exampleBlocking(){
    println("one")
    printlnDelayed("two")
    println("three")
}
