class Fish : Animal {
    constructor(
        energy: Int,
        weight: Int,
        maxAge: Int,
        name: String
    ) : super(energy, weight, maxAge, name)

    constructor(
        energy: Int,
        weight: Int,
        maxAge: Int,
        name: String,
        isNewborn: Boolean,
    ) : super(energy, weight, maxAge, name, isNewborn)

    override fun move() {
        super.move()
        if (isCanMove) {
            println("плывет\n")
        }
    }

    override fun procreate(): Fish {
        println("\nРождается $name")
        return Fish(
            energy = (1..10).random(),
            weight = (1..5).random(),
            maxAge = maxAge,
            name = name,
            isNewborn = true,
        )
    }
}