package currencies.jfyg.cryptomarketcap.data

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import currencies.jfyg.cryptomarketcap.model.Currency
import java.util.*

class DataRepositoryImpl(private val moshi: Moshi) {

    fun getCurrencies(jsonString: String): List<Currency> {
        val type = Types.newParameterizedType(Currency::class.java, Currency::class.java)
        val adapter: JsonAdapter<Currency> = moshi.adapter(type)


        return listOf(adapter.fromJson(jsonString) ?: Currency())
    }

}