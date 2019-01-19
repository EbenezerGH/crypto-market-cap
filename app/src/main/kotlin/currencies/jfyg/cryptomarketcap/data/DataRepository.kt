package currencies.jfyg.cryptomarketcap.data

import currencies.jfyg.cryptomarketcap.model.Currency

interface DataRepository {

    fun getCurrencies(jsonString: String): List<Currency>

}