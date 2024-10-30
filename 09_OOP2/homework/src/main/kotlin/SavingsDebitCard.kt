class SavingsDebitCard: DebitCard() {
    override fun topUp(amount: Double) {
        val accumulation = getAccumulation(amount)
        balance += (amount + accumulation)
        printTopUpInfo(amount)
        printAccumulation(accumulation)
    }

    override fun getTotalInfo() {
        println("Информацию о всех доступных средствах:")
        println("Баланс: $balance")
    }

    override fun makePayment(amount: Double): Boolean {
        val canMakePayment = writeOff(amount)

        if (canMakePayment) printPaymentInfo(amount)

        return canMakePayment
    }

    override fun getProgramInfo() {
        println("Программа: Накопление в размере $accumulationPercentage% от суммы пополнений.")
    }

    private fun getAccumulation(amount: Double): Double {
        return amount * accumulationPercentage
    }

    private fun printAccumulation(accumulation: Double) {
        println("Накопления: $accumulation\n")
    }

    companion object {
        const val accumulationPercentage = 0.005
    }
}