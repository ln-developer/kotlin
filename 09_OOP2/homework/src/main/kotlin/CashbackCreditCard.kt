class CashbackCreditCard(creditLimit: Int): CreditCard(creditLimit) {
    override fun makePayment(amount: Double): Boolean {
        val canMakePayment = writeOff(amount)

        if (canMakePayment) printPaymentInfo(amount)
        if (amount > minPaymentValue) topUp(getCashback(amount))

        return canMakePayment
    }

    override fun getTotalInfo() {
        getBalanceInfo()
        println("Кредитные средства: $creditFunds")
        println("Собственные средства: $ownFunds")
    }

    override fun getProgramInfo() {
        println("Программа: Потенциальный кэшбэк $cashbackValuePercentage% от покупок при условии трат больше $minPaymentValue тыс.")
    }

    private fun getCashback(amount: Double): Double {
        return amount * (cashbackValuePercentage / 100.0)
    }

    companion object {
        const val cashbackValuePercentage = 5
        const val minPaymentValue = 5000
    }
}