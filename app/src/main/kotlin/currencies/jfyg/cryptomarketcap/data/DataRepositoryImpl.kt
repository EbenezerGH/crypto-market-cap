package currencies.jfyg.cryptomarketcap.data

import com.google.gson.Gson
import currencies.jfyg.cryptomarketcap.model.Currency

class DataRepositoryImpl(private val gson: Gson) : DataRepository {

    override fun getCurrencies(jsonString: String): List<Currency> {
        return gson.fromJson(jsonString, Array<Currency>::class.java).toList()
    }

}
