import kotlin.random.Random

open class Animal(
    var energy: Int,
    var weight: Int,
    val maxAge: Int,
    val name: String,
) {
    constructor(
        energy: Int,
        weight: Int,
        maxAge: Int,
        name: String,
        isNewborn: Boolean,
    ) : this(energy, weight, maxAge, name) {
        if (isNewborn) currentAge = 0
    }

    private var currentAge: Int = (1..maxAge).random()
    protected var isCanMove: Boolean = true
    var isTooOld = currentAge >= maxAge

    fun sleep() {
        energy += sleepingEnergyReceived
        currentAge += 1
        isTooOld = currentAge >= maxAge
        println("\n$name спит\n")
    }

    fun eat() {
        energy += eatingEnergyReceived
        weight += eatingWeightReceived

        tryIncrementAge()

        println("\n$name ест\n")
    }

    open fun move() {
        if (tryMove()) {
            energy -= movingEnergyLoss
            weight -= movingWeightLoss

            tryIncrementAge()

            println("\n$name передвигается")
        }
    }

    open fun procreate(): Animal {
        println("\nРождается $name")
        return Animal(
            energy = (1..10).random(),
            weight = (1..5).random(),
            maxAge = maxAge,
            name = name,
            isNewborn = true,
        )
    }

    private fun tryIncrementAge() {
        if (Random.nextBoolean()) {
            currentAge += 1
            isTooOld = currentAge >= maxAge
        }
    }

    private fun tryMove(): Boolean {
        isCanMove =
            energy - movingEnergyLoss >= 0 && weight - movingWeightLoss >= 0 && currentAge - 1 <= maxAge
        return isCanMove
    }

    fun printAnimalInfo() {
        println("Имя - $name")
        println("Энергия - $energy")
        println("Вес - $weight")
        println("Максимальный возраст - $maxAge")
        println("Текущий возраст - $currentAge\n")
    }

    companion object {
        const val movingEnergyLoss = 5
        const val movingWeightLoss = 1
        const val eatingEnergyReceived = 3
        const val eatingWeightReceived = 1
        const val sleepingEnergyReceived = 5
    }
}