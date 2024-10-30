fun main() {
    var n: Int
    do {
        println("Введите число (число должно быть больше 0)")
        n = readlnOrNull()?.toIntOrNull() ?: 0
    } while (n <= 0)

    println("Вывод информации 1: ${getFibonacciValueRecursive(n)}")
    println("Вывод информации 2: ${getFibonacciValueLoop(n)}")
}

fun getFibonacciValueRecursive(n: Int): Int {
    if (n == 1) return 1
    else if (n == 2) return 1
    else return getFibonacciValueRecursive(n - 1) + getFibonacciValueRecursive(n - 2)
}

fun getFibonacciValueLoop(n: Int): Int {
    var fib1: Int = 1
    var fib2: Int = 1
    for (i in 3 .. n) {
        val sum = fib1 + fib2
        fib1 = fib2
        fib2 = sum
    }
    return fib2
}