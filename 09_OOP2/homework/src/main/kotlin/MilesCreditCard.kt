class MilesCreditCard(creditLimit: Int): CreditCard(creditLimit) {
    private var miles: Double = 0.0

    override fun makePayment(amount: Double): Boolean {
        val canMakePayment = writeOff(amount)

        if (canMakePayment) {
            printPaymentInfo(amount)
            miles += getMilesCashback(amount)
        }

        return canMakePayment
    }

    override fun getTotalInfo() {
        getBalanceInfo()
        println("Кредитные средства: $creditFunds")
        println("Собственные средства: $ownFunds")
        println("Накопленные мили: $miles")
    }

    override fun getProgramInfo() {
        println("Программа: $cashbackMilesPercentage% кэшбэк милями за все покупки.")
    }

    private fun getMilesCashback(amount: Double): Double {
        val milesCashback = amount * (cashbackMilesPercentage / 100.0)
        println("Начислено миль: $milesCashback\n")
        return milesCashback
    }

    companion object {
        const val cashbackMilesPercentage = 2
    }
}