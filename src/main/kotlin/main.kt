
import kotlinx.coroutines.*

fun main(args: Array<String>) {
    exampleLaunchCoroutineScope()
}

suspend fun printlnDelayed(message: String) {
    // Complex calculation
    delay(1000)
    println(message)
}

fun exampleBlocking() = runBlocking {
    println("one")
    printlnDelayed("two")
    println("three")
}

// Running on another thread but still blocking the main thread
fun exampleBlockingDispatcher() {
    runBlocking(Dispatchers.Default) {
        println("one - from thread ${Thread.currentThread().name}")
        printlnDelayed("two - from thread ${Thread.currentThread().name}")
    }
    // Outside of runBlocking to show that it's running in the blocked main thread
    println("three - from thread ${Thread.currentThread().name}")
    // It still runs only after the runBlocking is fully executed.
}

fun exampleLaunchGlobal() = runBlocking {
    println("one - from thread ${Thread.currentThread().name}")

    GlobalScope.launch {
        printlnDelayed("two - from thread ${Thread.currentThread().name}")
    }

    println("three - from thread ${Thread.currentThread().name}")
    delay(2000)//very very important
}

fun exampleLaunchGlobalWaiting() = runBlocking {
    println("one - from thread ${Thread.currentThread().name}")

    val job = GlobalScope.launch {
        printlnDelayed("two - from thread ${Thread.currentThread().name}")
    }

    println("three - from thread ${Thread.currentThread().name}")
    job.join() //whenever GlobalScope.launch job finish
}

fun exampleLaunchCoroutineScope() = runBlocking {
    println("one - from thread ${Thread.currentThread().name}")

    this.launch {
        printlnDelayed("two - from thread ${Thread.currentThread().name}")
    }

    println("three - from thread ${Thread.currentThread().name}")
}
