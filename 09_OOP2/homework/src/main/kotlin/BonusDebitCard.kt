class BonusDebitCard: DebitCard() {
    private var bonuses: Int = 0

    override fun topUp(amount: Double) {
        balance += amount
        printTopUpInfo(amount)
    }

    override fun makePayment(amount: Double): Boolean {
        val canMakePayment = writeOff(amount)

        if (canMakePayment) {
            printPaymentInfo(amount)
            bonuses += getBonuses(amount)
        }

        return canMakePayment
    }

    override fun getProgramInfo() {
        println("Программа: Бонусные баллы в размере $paymentBonusPercentage% от покупок.")
    }

    override fun getTotalInfo() {
        println("Информацию о всех доступных средствах:")
        println("Баланс: $balance")
        println("Бонусные баллы: $bonuses")
    }

    private fun getBonuses(payment: Double): Int {
        val bonuses = (payment * (paymentBonusPercentage / 100.toDouble())).toInt()

        printAccrueBonusesInfo(bonuses)

        return bonuses
    }

    private fun printAccrueBonusesInfo(bonuses: Int) {
        println("Начислено бонусов: $bonuses\n")
    }

    companion object {
        const val paymentBonusPercentage = 1
    }
}