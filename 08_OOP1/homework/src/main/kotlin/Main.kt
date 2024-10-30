fun main() {
    val natureReserve = NatureReserve(
        birds = mutableListOf(
            Bird(
                energy = (1..100).random(),
                weight = 120,
                maxAge = 75,
                name = "Африканский страус",
            ),
            Bird(
                energy = (1..100).random(),
                weight = 2,
                maxAge = 15,
                name = "Ястреб-тетеревятник",
            ),
            Bird(
                energy = (1..100).random(),
                weight = 35,
                maxAge = 25,
                name = "Императорский пингвин",
            ),
            Bird(
                energy = (1..100).random(),
                weight = 4,
                maxAge = 50,
                name = "Розовый фламинго",
            ),
            Bird(
                energy = (1..100).random(),
                weight = 11,
                maxAge = 30,
                name = "Странствующий альбатрос",
            )
        ),
        fishes = mutableListOf(
            Fish(
                energy = (1..100).random(),
                weight = 548,
                maxAge = 45,
                name = "Тигровая акула",
            ),
            Fish(
                energy = (1..100).random(),
                weight = 8,
                maxAge = 30,
                name = "Карп кои",
            ),
            Fish(
                energy = (1..100).random(),
                weight = 20,
                maxAge = 28,
                name = "Скат-хвостокол",
            )
        ),
        dogs = mutableListOf(
            Dog(
                energy = (1..100).random(),
                weight = 7,
                maxAge = 16,
                name = "Джек-рассел-терьер",
            ),
            Dog(
                energy = (1..100).random(),
                weight = 30,
                maxAge = 12,
                name = "Американский стаффордширский терьер",
            )
        ),
        animals = mutableListOf(
            Animal(
                energy = (1..100).random(),
                weight = 250,
                maxAge = 40,
                name = "Афалина",
            ),
            Animal(
                energy = (1..100).random(),
                weight = 6000,
                maxAge = 70,
                name = "Африканский слон",
            ),
            Animal(
                energy = (1..100).random(),
                weight = 7,
                maxAge = 13,
                name = "Коала",
            )
        )
    )

    natureReserve.runNatureReserveLifeCycle()
    natureReserve.printNumberOfAnimals()
}