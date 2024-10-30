package tv

import java.util.*

object Channels {
    private val channels = setOf<Channel>(
        Channel(
            channelName = "Первый канал",
            channelType = "Эфирный",
            program = mapOf(
                "00:00" to "ПОДКАСТ.ЛАБ",
                "03:00" to "Новости",
                "05:00" to "Доброе утро",
                "09:00" to "Жить здорово!",
            )
        ),
        Channel(
            channelName = "Россия 1",
            channelType = "Эфирный",
            program = mapOf(
                "03:00" to "Вести",
                "06:00" to "О самом главном",
                "09:00" to "Утро России",
            )
        ),
        Channel(
            channelName = "Матч ТВ",
            channelType = "Спортивный",
            program = mapOf(
                "00:00" to "Футбол. Чемпионат мира",
                "03:00" to "Все на Матч!",
                "05:00" to "Здоровый образ",
                "09:00" to "Магия большого спорта",
            )
        ),
        Channel(
            channelName = "НТВ",
            channelType = "Эфирный",
            program = mapOf(
                "05:00" to "Сегодня",
                "07:00" to "Место встречи",
                "09:00" to "Утро. Самое лучшее",
            )
        ),
        Channel(
            channelName = "Пятый канал",
            channelType = "Эфирный",
            program = mapOf(
                "05:00" to "Известия",
                "07:00" to "Глухарь",
                "09:00" to "След",
            )
        ),
        Channel(
            channelName = "Россия К",
            channelType = "Эфирный",
            program = mapOf(
                "05:00" to "Новости культуры",
                "07:00" to "Легенды и мифы",
                "09:00" to "Цвет времени",
            )
        ),
        Channel(
            channelName = "Россия 24",
            channelType = "Эфирный",
            program = mapOf(
                "05:00" to "Новости",
                "07:00" to "Большая страна",
                "09:00" to "Новости",
            )
        ),
        Channel(
            channelName = "Карусель",
            channelType = "Детский",
            program = mapOf(
                "17:00" to "Ералаш",
                "19:00" to "Ми-ми-мишки",
                "20:30" to "Спокойной ночи, малыши!",
            )
        ),
        Channel(
            channelName = "Рен-ТВ",
            channelType = "Эфирный",
            program = mapOf(
                "01:00" to "Самые шокирующие гипотезы",
                "03:00" to "Военная тайна с Игорем Прокопенко",
                "04:30" to "Тайны Чапман",
            )
        ),
        Channel(
            channelName = "СТС",
            channelType = "Развлекательный",
            program = mapOf(
                "01:00" to "Уральские пельмени",
                "03:00" to "6 кадров",
                "06:00" to "Кино в деталях",
            )
        ),
        Channel(
            channelName = "ТВ-3",
            channelType = "Эфирный",
            program = mapOf(
                "01:00" to "Городские легенды",
                "03:00" to "Гадалка",
                "06:00" to "Охотники за привидениями",
            )
        ),
        Channel(
            channelName = "Пятница",
            channelType = "Развлекательный",
            program = mapOf(
                "01:00" to "Битва шефов",
                "03:00" to "Умнее всех",
                "06:00" to "Пятница News",
            )
        ),
        Channel(
            channelName = "ТНТ",
            channelType = "Развлекательный",
            program = mapOf(
                "01:00" to "Импровизация",
                "03:00" to "Однажды в России",
                "06:00" to "Полицейский с Рублевки",
            )
        ),
        Channel(
            channelName = "Домашний",
            channelType = "Эфирный",
            program = mapOf(
                "01:00" to "Давай разведемся!",
                "03:00" to "Понять. Простить",
                "06:00" to "Порча. Забыть",
            )
        ),
        Channel(
            channelName = "Звезда",
            channelType = "Эфирный",
            program = mapOf(
                "01:00" to "Новости дня",
                "03:00" to "Улика из прошлого",
                "06:00" to "Гений разведки",
            )
        ),
    )

    fun getRandomChannels(): List<Channel> {
        return channels.shuffled(Random()).subList(0, (10..channels.size).random())
    }
}