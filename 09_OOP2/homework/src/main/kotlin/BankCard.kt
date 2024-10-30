abstract class BankCard {

    protected var balance: Double = 0.0
    abstract fun topUp(amount: Double)

    protected abstract fun writeOff(amount: Double): Boolean

    abstract fun makePayment(amount: Double): Boolean

    abstract fun getProgramInfo()

    fun getBalanceInfo() {
        println("\nБаланс: $balance\n")
    }

    protected fun printPaymentError() {
        println("\nОшибка! Недостаточно средств.")
        println("Необходимо пополнить баланс.\n")
    }

    protected fun printTopUpInfo(amount: Double) {
        println("Зачисление средств: $amount")
        getBalanceInfo()
    }

    protected fun printPaymentInfo(amount: Double) {
        println("Покупка: $amount")
        getBalanceInfo()
    }

    abstract fun getTotalInfo()
}