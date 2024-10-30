class Dog : Animal {
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
            println("бежит\n")
        }
    }

    override fun procreate(): Dog {
        println("\nРождается $name")
        return Dog(
            energy = (1..10).random(),
            weight = (1..5).random(),
            maxAge = maxAge,
            name = name,
            isNewborn = true,
        )
    }
}