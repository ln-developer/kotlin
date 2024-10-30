package tv

class Channel(
    val channelName: String,
    private val channelType: String,
    private val program: Map<String, String>
) {
    fun printChannelProgram() {
        println("Канал: $channelName ($channelType)")
        program.forEach { (key, value) ->
            println("Время: $key - Передача: $value")
        }
    }
}