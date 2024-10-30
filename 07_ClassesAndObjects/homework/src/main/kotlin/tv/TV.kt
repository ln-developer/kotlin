package tv

class TV(val mark: String, val model: String, val displaySize: Double) {
    var isOn = false
        private set

    private val channelList: List<Channel> = Channels.getRandomChannels()

    val channelListSize = channelList.size

    var volume = 0
        private set

    var currentChannelIndex = 0
        private set

    fun printTVInfo() {
        println("\nМарка: $mark")
        println("Модель: $model")
        println("Размер диагонали: $displaySize\n")
    }

    fun on() {
        println("\nВключение телевизора\n")
        isOn = true
    }

    fun off() {
        println("\nВыключение телевизора\n")
        isOn = false
    }

    fun turnUpVolume(increment: Int) {
        print("\tУвеличение громкости на $increment%: ")
        volume = minOf(maxVolume, volume + increment)
        println("Громкость: $volume%")
    }

    fun turnDownVolume(decrement: Int) {
        print("\tУменьшение громкости на $decrement%: ")
        volume = maxOf(0, volume - decrement)
        println("Громкость: $volume%")
    }

    fun setChannel(channelNumber: Int): Boolean {
        if (!isOn) on()

        return if (checkIsChannelExists(channelNumber)) {
            currentChannelIndex = channelNumber
            printCurrentChannel()
            true
        } else {
            println("Канала с номером $channelNumber не существует")
            false
        }
    }

    fun nextChannel() {
        if (!isOn) {
            on()
        } else {
            currentChannelIndex =
                if (currentChannelIndex + 1 > channelList.lastIndex) 0
                else currentChannelIndex + 1
        }
        printCurrentChannel()
    }

    fun prevChannel() {
        if (!isOn) {
            on()
        } else {
            currentChannelIndex =
                if (currentChannelIndex - 1 < 0) channelList.lastIndex
                else currentChannelIndex - 1
        }
        printCurrentChannel()
    }

    fun printChannelList() {
        println("\nСписок каналов")
        channelList.forEachIndexed { index, channel ->
            println("$index - ${channel.channelName}")
        }
    }

    fun getChannelInfo() {
        channelList.elementAt(currentChannelIndex).printChannelProgram()
    }

    private fun checkIsChannelExists(channelNumber: Int): Boolean {
        return channelNumber >= 0 && channelNumber <= channelList.lastIndex
    }

    private fun printCurrentChannel() {
        println("\tВключение $currentChannelIndex канала")
    }


    companion object {
        const val maxVolume = 100
    }
}