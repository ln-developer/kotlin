class EURConverter: CurrencyConverter, Convertable {
    override val currencyCode: String = "EUR"

    override fun convertRub(sum: Double) {
        getConvertedSum(sum, currencyCode)
    }
}