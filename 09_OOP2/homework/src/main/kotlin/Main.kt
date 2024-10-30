fun main() {
    val bonusDebitCard = BonusDebitCard()
    val savingsDebitCard = SavingsDebitCard()
    val cashbackCreditCard = CashbackCreditCard(100000)
    val milesCreditCard = MilesCreditCard(500000)

    println("Вывод информации 1")
    bonusDebitCard.getProgramInfo()
    bonusDebitCard.topUp(34000.0)
    bonusDebitCard.makePayment(270.0)
    bonusDebitCard.makePayment(3499.5)
    bonusDebitCard.makePayment(31834.0)
    bonusDebitCard.topUp(5000.0)
    bonusDebitCard.makePayment(31834.0)
    bonusDebitCard.getTotalInfo()

    println("\n------------------------------------\n")

    println("Вывод информации 2")
    savingsDebitCard.getProgramInfo()
    savingsDebitCard.topUp(34000.0)
    savingsDebitCard.makePayment(270.0)
    savingsDebitCard.makePayment(3499.5)
    savingsDebitCard.makePayment(31834.0)
    savingsDebitCard.topUp(5000.0)
    savingsDebitCard.makePayment(31834.0)
    savingsDebitCard.getTotalInfo()

    println("\n------------------------------------\n")

    println("Вывод информации 3")
    cashbackCreditCard.getProgramInfo()
    cashbackCreditCard.getBalanceInfo()
    cashbackCreditCard.makePayment(270.0)
    cashbackCreditCard.topUp(4000.0)
    cashbackCreditCard.makePayment(5499.5)
    cashbackCreditCard.topUp(5000.0)
    cashbackCreditCard.getTotalInfo()

    println("\n------------------------------------\n")

    println("Вывод информации 4")
    milesCreditCard.getProgramInfo()
    milesCreditCard.getBalanceInfo()
    milesCreditCard.makePayment(270.0)
    milesCreditCard.topUp(4000.0)
    milesCreditCard.makePayment(5499.5)
    milesCreditCard.topUp(5000.0)
    milesCreditCard.getTotalInfo()
}

