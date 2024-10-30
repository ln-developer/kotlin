object Converters {
    fun get(currencyCode: String): CurrencyConverter {
        return when (currencyCode.uppercase()) {
            CurrencyCode.EUR.toString() -> EURConverter()
            CurrencyCode.GBP.toString() -> GBPConverter()
            CurrencyCode.USD.toString() -> USDConverter()
            else -> object : CurrencyConverter {
                override val currencyCode: String = currencyCode

                override fun convertRub(sum: Double) {
                    println("Ошибка: Конвертер для валюты ${currencyCode.uppercase()} не найден\n")
                }
            }
        }
    }
}