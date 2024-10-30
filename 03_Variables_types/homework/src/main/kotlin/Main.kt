fun main() {
    val firstName = "Jane"
    val lastName = "Doe"
    var height = 1.73
    val weight = 81.7f
    var isChild = height * 100 < 150 || weight < 40
    var info = "first name: $firstName, last name: $lastName, height: $height, weight: $weight, is child: $isChild"
    println(info)
    height = 1.49
    isChild = height * 100 < 150 || weight < 40
    info = "first name: $firstName, last name: $lastName, height: $height, weight: $weight, is child: $isChild"
    println(info)
}