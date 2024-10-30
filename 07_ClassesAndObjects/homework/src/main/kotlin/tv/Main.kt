package tv

fun main() {
    val xiaomiTV = TV(mark = "Xiaomi", model = "A2", displaySize = 43.0)
    val sonyTV = TV(mark = "Sony", model = "KD-75X81J", displaySize = 74.5)

    println("Вывод информации 1")
    xiaomiTV.printTVInfo()
    printStatus(xiaomiTV)
    xiaomiTV.on()
    printStatus(xiaomiTV)
    xiaomiTV.printChannelList()
    println("\nПереключение канала на заданный")
    var setSuccessfully = xiaomiTV.setChannel((0..xiaomiTV.channelListSize).random())
    if (setSuccessfully) xiaomiTV.getChannelInfo()
    println("\nТекущая громкость телевизора ${xiaomiTV.volume}%")
    setVolume(xiaomiTV, isUp = true)
    println("\nНомер текущего канала - ${xiaomiTV.currentChannelIndex}")
    println("\nПереключение каналов в порядке убывания")
    switchChannels(xiaomiTV, isNext = false)
    println("\nТекущая громкость телевизора ${xiaomiTV.volume}%")
    setVolume(xiaomiTV, isUp = false)
    println("\nНомер текущего канала - ${xiaomiTV.currentChannelIndex}")
    println("\nПереключение каналов в порядке возрастания")
    switchChannels(xiaomiTV, isNext = true)
    xiaomiTV.off()

    println("------------------------------------\n")

    println("Вывод информации 2")
    sonyTV.printTVInfo()
    sonyTV.printChannelList()
    printStatus(sonyTV)
    println("\nПереключение канала на заданный")
    // телевизор не был включен, поэтому функция setChannel сначала включит телевизор
    // затем выставит заданный канал, если канал с таким номером существует
    setSuccessfully = sonyTV.setChannel((0..sonyTV.channelListSize).random())
    if (setSuccessfully) sonyTV.getChannelInfo()
    printStatus(sonyTV)
    println("\nТекущая громкость телевизора ${sonyTV.volume}%")
    setVolume(sonyTV, isUp = true)
    sonyTV.off()
    printStatus(sonyTV)
    println("\nНомер текущего канала - ${sonyTV.currentChannelIndex}")
    // телевизор был выключен, поэтому функция nextChannel включит телевизор
    // на канале, который был до выключения
    println("\nПереключение каналов в порядке возрастания")
    switchChannels(sonyTV, isNext = true)
    println("\nТекущая громкость телевизора ${sonyTV.volume}%")
    setVolume(sonyTV, isUp = false)
    println("\nНомер текущего канала - ${sonyTV.currentChannelIndex}")
    println("\nПереключение каналов в порядке убывания")
    switchChannels(sonyTV, isNext = false)
    sonyTV.off()
}

fun setVolume(tv: TV, isUp: Boolean) {
    for (i in 0..5) {
        if (isUp) tv.turnUpVolume((1..10).random())
        else tv.turnDownVolume((1..10).random())
        Thread.sleep(500)
    }
}

fun switchChannels(tv: TV, isNext: Boolean) {
    for (i in 0..5) {
        if (isNext) tv.nextChannel()
        else tv.prevChannel()
        Thread.sleep(500)
    }
}

fun printStatus(tv: TV) {
    println("Сейчас телевизор ${tv.mark} ${if (tv.isOn) "включен" else "выключен"}")
}