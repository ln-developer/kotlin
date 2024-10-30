fun main() {
    val resultStr = "F2p)v\"y233{0->c}ttelciFc"
    val firstStr: String = resultStr.substring(0, resultStr.length / 2)
    val secondStr: String = resultStr.substring(resultStr.length / 2)
    val decryptedFirstStr: String = decryptFistStr(firstStr)
    val decryptedSecondStr: String = decryptSecondStr(secondStr)
    val newResultStr: String = decryptedFirstStr + decryptedSecondStr
    println(newResultStr)
}

fun decryptFistStr(str: String): String {
    return shift(shift(str) { it + 1 }.replace('5', 's').replace('4', 'u')) { it - 3 }.replace('0', 'o')
}

fun decryptSecondStr(str: String): String {
    return shift(str.reversed()) { it - 4 }.replace('_', ' ')
}

fun shift(str: String, shiftFn: (Char) -> Char): String {
    return str.map { shiftFn(it) }.joinToString("")
}