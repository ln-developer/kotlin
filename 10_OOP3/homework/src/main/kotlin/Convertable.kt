interface Convertable {
    fun getConvertedSum(sum: Double, currencyCode: String): Double {
        val currencyRate = CurrencyRate.getRateByCurrencyCode(CurrencyCode.valueOf(currencyCode))
        val convertedSum = sum * currencyRate
        println("Курс $currencyCode: $currencyRate RUB")
        println("$sum RUB = $convertedSum $currencyCode\n")
        return convertedSum
    }
}