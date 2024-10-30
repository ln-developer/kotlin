class GBPConverter: CurrencyConverter, Convertable {
    override val currencyCode: String = "GBP"

    override fun convertRub(sum: Double) {
        getConvertedSum(sum, currencyCode)
    }
}