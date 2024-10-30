class USDConverter: CurrencyConverter, Convertable {
    override val currencyCode: String = "USD"

    override fun convertRub(sum: Double) {
        getConvertedSum(sum, currencyCode)
    }
}