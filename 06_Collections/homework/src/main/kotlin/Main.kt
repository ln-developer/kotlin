fun main() {
    var n: Int
    do {
        println("Введите число (число должно быть больше 0)")
        n = readlnOrNull()?.toIntOrNull() ?: 0
    } while (n <= 0)

    val phoneNumberList = getPhoneNumbers(n)
    println("Исходный список номеров телефонов: $phoneNumberList")

    val filteredPhoneNumberList = phoneNumberList.filter { "+7" in it }
    println("Номера, начинающиеся с +7: $filteredPhoneNumberList")

    val uniquePhoneNumbers = filteredPhoneNumberList.toSet()
    println("Уникальные номера: $uniquePhoneNumbers")

    val uniquePhoneNumbersSize = uniquePhoneNumbers.size
    println("Размер списка уникальных номеров: $uniquePhoneNumbersSize")

    // вывод суммы длин всех номеров с учетом спец символов
    println("Сумма длин всех номеров (с учетом спец символов): " +
            "${uniquePhoneNumbers.sumOf { it.length }}")
    // вывод суммы длин всех номеров с подсчетом только цифр
    println("Сумма длин всех номеров (без учета спец символов): " +
            "${uniquePhoneNumbers.sumOf { it.filter { c -> c.isDigit() }.length }}")

    val phonebook = setNames(uniquePhoneNumbers)
    println("Телефонный справочник: ")
    printPhoneBook(phonebook)

    println("Телефонный справочник отсортированный по номерам телефонов")
    printPhoneBookSortedByNumber(phonebook)

    println("Телефонный справочник отсортированный по именам абонентов")
    printPhoneBookSortedByName(phonebook)
}

fun getPhoneNumbers(n: Int): MutableList<String> {
    val phoneNumberList = mutableListOf<String>()
    var i = n
    while (i > 0) {
        println("Введите номер телефона")
        val phoneNumber = readlnOrNull() ?: ""
        val isCorrect = checkPhoneNumber(phoneNumber)
        if (isCorrect) {
            phoneNumberList.add(phoneNumber)
            i--
        } else println("Некорректный номер телефона")
    }
    return phoneNumberList
}

fun setNames(list: Set<String>): MutableMap<String, String> {
    val phonebook = mutableMapOf<String, String>()
    var i = 0
    while (i < list.size) {
        println("Введите имя человека с номером телефона ${list.elementAt(i)}:")
        val name = readlnOrNull() ?: ""
        if (name != "") {
            phonebook.put(list.elementAt(i), name)
            i++
        } else println("Ошибка! Имя не должно быть пустым")
    }
    return phonebook
}

fun printPhoneBook(phonebook: MutableMap<String, String>) {
    phonebook.forEach { (key, value) ->
        println("Абонент: $value. Номер телефона: $key")
    }
}

fun printPhoneBookSortedByNumber(phonebook: MutableMap<String, String>) {
    println(phonebook.toSortedMap())
}

fun printPhoneBookSortedByName(phonebook: MutableMap<String, String>) {
    println(phonebook.toSortedMap(compareBy { phonebook[it] }))
}

fun checkPhoneNumber(phone: String): Boolean {
    val pattern = Regex("^(\\+7|8)?([(]?\\d{3}[)]?)?\\s?\\d{3}\\-?\\d{2}\\-?\\d{2}\$")
    return phone.matches(pattern)
}