class NatureReserve(
    private var birds: MutableList<Bird>,
    private var fishes: MutableList<Fish>,
    private var dogs: MutableList<Dog>,
    private var animals: MutableList<Animal>,
) {
    private var numberOfDeadBirds: Int = 0
    private var numberOfDeadFishes: Int = 0
    private var numberOfDeadDogs: Int = 0
    private var numberOfDeadAnimals: Int = 0

    private var numberOfNewbornBirds: Int = 0
    private var numberOfNewbornFishes: Int = 0
    private var numberOfNewbornDogs: Int = 0
    private var numberOfNewbornAnimals: Int = 0

    private fun procreateBird(bird: Bird, birdsIterator: MutableListIterator<Bird>) {
        val newbornBird = bird.procreate()
        newbornBird.printAnimalInfo()
        birdsIterator.add(newbornBird)
        numberOfNewbornBirds++
    }

    private fun procreateFish(fish: Fish, fishesIterator: MutableListIterator<Fish>) {
        val newbornFish = fish.procreate()
        newbornFish.printAnimalInfo()
        fishesIterator.add(newbornFish)
        numberOfNewbornFishes++
    }

    private fun procreateDog(dog: Dog, dogsIterator: MutableListIterator<Dog>) {
        val newbornDog = dog.procreate()
        newbornDog.printAnimalInfo()
        dogsIterator.add(newbornDog)
        numberOfNewbornDogs++
    }

    private fun procreateAnimal(animal: Animal, animalsIterator: MutableListIterator<Animal>) {
        val newbornAnimal = animal.procreate()
        newbornAnimal.printAnimalInfo()
        animalsIterator.add(newbornAnimal)
        numberOfNewbornAnimals++
    }

    private fun doRandomActionBird(bird: Bird, birdsIterator: MutableListIterator<Bird>) {
        when ((1..4).random()) {
            1 -> bird.sleep()
            2 -> bird.eat()
            3 -> bird.move()
            4 -> procreateBird(bird, birdsIterator)
        }
    }

    private fun doRandomActionFish(fish: Fish, fishesIterator: MutableListIterator<Fish>) {
        when ((1..4).random()) {
            1 -> fish.sleep()
            2 -> fish.eat()
            3 -> fish.move()
            4 -> procreateFish(fish, fishesIterator)
        }
    }

    private fun doRandomActionDog(dog: Dog, dogsIterator: MutableListIterator<Dog>) {
        when ((1..4).random()) {
            1 -> dog.sleep()
            2 -> dog.eat()
            3 -> dog.move()
            4 -> procreateDog(dog, dogsIterator)
        }
    }

    private fun doRandomActionAnimal(animal: Animal, animalsIterator: MutableListIterator<Animal>) {
        when ((1..4).random()) {
            1 -> animal.sleep()
            2 -> animal.eat()
            3 -> animal.move()
            4 -> procreateAnimal(animal, animalsIterator)
        }
    }

    private fun removeDeadAnimals() {
        birds.removeAll { it.isTooOld }
        fishes.removeAll { it.isTooOld }
        dogs.removeAll { it.isTooOld }
        animals.removeAll { it.isTooOld }
    }

    private fun countDeadAnimals() {
        numberOfDeadBirds = birds.count { it.isTooOld }
        numberOfDeadFishes = fishes.count { it.isTooOld }
        numberOfDeadDogs = dogs.count { it.isTooOld }
        numberOfDeadAnimals = animals.count { it.isTooOld }
    }

    private fun runBirdsLifeCycle() {
        val birdsIterator = birds.listIterator()
        while (birdsIterator.hasNext()) {
            doRandomActionBird(birdsIterator.next(), birdsIterator)
        }
    }

    private fun runFishesLifeCycle() {
        val fishesIterator = fishes.listIterator()
        while (fishesIterator.hasNext()) {
            doRandomActionFish(fishesIterator.next(), fishesIterator)
        }
    }

    private fun runDogsLifeCycle() {
        val dogsIterator = dogs.listIterator()
        while (dogsIterator.hasNext()) {
            doRandomActionDog(dogsIterator.next(), dogsIterator)
        }
    }

    private fun runAnimalsLifeCycle() {
        val animalsIterator = animals.listIterator()
        while (animalsIterator.hasNext()) {
            doRandomActionAnimal(animalsIterator.next(), animalsIterator)
        }
    }

    fun runNatureReserveLifeCycle() {
        for (i in 0..5) {
            println("============== Итерация $i ==============")
            runBirdsLifeCycle()
            runFishesLifeCycle()
            runDogsLifeCycle()
            runAnimalsLifeCycle()
            println("\n-----------------------------------------")
            println("Появилось птиц - $numberOfNewbornBirds")
            println("Появилось рыб - $numberOfNewbornFishes")
            println("Появилось собак - $numberOfNewbornDogs")
            println("Появилось других животных - $numberOfNewbornAnimals")
            println("-----------------------------------------\n")
        }

        countDeadAnimals()
        removeDeadAnimals()
    }

    fun printNumberOfAnimals() {
        if (birds.size > 0 || fishes.size > 0 || dogs.size > 0 || animals.size > 0) {
            println("\nВсего птиц - ${birds.size}, погибло - $numberOfDeadBirds")
            println("Всего рыб - ${fishes.size}, погибло - $numberOfDeadFishes")
            println("Всего собак - ${dogs.size}, погибло - $numberOfDeadDogs")
            println("Всего других животных - ${animals.size}, погибло - $numberOfDeadAnimals")
        } else println("К сожалению, все животные в заповеднике погибли")
    }
}