abstract class CreditCard(private val creditLimit: Int): BankCard() {

    protected var ownFunds: Double = 0.0

    protected var creditFunds: Double = creditLimit.toDouble()

    init {
        balance += creditLimit
    }

    override fun topUp(amount: Double) {
        // "кредитных" средств меньше кредитного лимита
        if (creditFunds < creditLimit) {
            creditFunds += amount
            // разницу переносим в "собственные" средства
            if (creditFunds > creditLimit) {
                val diff = creditFunds - creditLimit
                creditFunds -= diff
                ownFunds = diff
            }
        } else ownFunds += amount
        updateBalance()
        printTopUpInfo(amount)
    }

    override fun writeOff(amount: Double): Boolean {
        val canWriteOff: Boolean
        // имеются "собственные" средства
        if (ownFunds > 0) {
            // "собственных" средств достаточно для списания
            if (ownFunds - amount > 0) {
                ownFunds -= amount
                canWriteOff = true
            }
            // "собственных" средств не достаточно для списания
            else {
                // списываем разницу с "кредитных" средств
                // остальное будет списано с "собственных" средств
                creditFunds -= (amount - ownFunds)
                // обнуляем "собственные" средства
                ownFunds = 0.0
                canWriteOff = true
            }
        } else {
            // "кредитных" средств достаточно для списания
            if (creditFunds - amount > 0) {
                creditFunds -= amount
                canWriteOff = true
            } else {
                printPaymentError()
                getBalanceInfo()
                canWriteOff = false
            }
        }

        updateBalance()
        return canWriteOff
    }

    private fun updateBalance() {
        balance = creditFunds + ownFunds
    }
}