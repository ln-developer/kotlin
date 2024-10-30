abstract class DebitCard: BankCard() {
    override fun writeOff(amount: Double): Boolean {
        return if (balance - amount < 0) {
            printPaymentInfo(amount)
            printPaymentError()
            getBalanceInfo()
            false
        } else {
            balance -= amount
            true
        }
    }
}