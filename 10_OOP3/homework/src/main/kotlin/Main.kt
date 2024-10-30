import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val currencyRate = CurrencyRate
    currencyRate.getActualRates()

    var sum: Double

    do {
        println("Введите сумму в рублях (сумма должна быть больше 0)")
        sum = readlnOrNull()?.toDoubleOrNull() ?: 0.0
        if (sum > 0.0) {
            val currencyCode = getCurrencyCode()
            if (currencyCode != null) {
                val converter = Converters.get(currencyCode)
                converter.convertRub(sum)
            }
        }
    } while (sum > 0.0)
}

fun getCurrencyCode(): String? {
    println("Введите международный код валюты, в который хотите конвертировать")
    println("Пример: USD, eur и тд")
    return readlnOrNull()
}