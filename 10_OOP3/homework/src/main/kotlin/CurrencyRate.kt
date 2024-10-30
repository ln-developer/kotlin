import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import models.DataResponse
import models.Currency
import kotlin.properties.Delegates

object CurrencyRate {
    private var eurRate by Delegates.notNull<Double>()
    private var gbpRate by Delegates.notNull<Double>()
    private var usdRate by Delegates.notNull<Double>()

    private const val apiUrl = "https://api.freecurrencyapi.com"
    private const val apiKey = "fca_live_rQLkVnqcG1qLqJ1PSPOgq73s7gNb0smTiOJM9MNR"
    private const val currencies = "EUR,USD,GBP"
    private const val baseCurrency = "RUB"

    fun getRateByCurrencyCode(currencyCode: CurrencyCode): Double {
        return when(currencyCode) {
            CurrencyCode.EUR -> eurRate
            CurrencyCode.GBP -> gbpRate
            CurrencyCode.USD -> usdRate
        }
    }

    suspend fun getActualRates() = coroutineScope {
        launch {
            val response: String = getCurrency()
            val data: DataResponse = Json.decodeFromString<Currency>(response).data
            setRates(data)
        }
    }

    private suspend fun getCurrency(): String = HttpClient().use {
        return it.get(
            apiUrl
        ) {
            url {
                appendPathSegments(listOf("v1", "latest"))
                parameters.append("apikey", apiKey)
                parameters.append("currencies", currencies)
                parameters.append("base_currency", baseCurrency)
            }
        }.body<String>()
    }

    private fun setRates(data: DataResponse) {
        eurRate = data.EUR
        gbpRate = data.GBP
        usdRate = data.USD
    }
}