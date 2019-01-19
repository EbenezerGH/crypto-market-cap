package currencies.jfyg.cryptomarketcap.data

import com.google.gson.Gson
import currencies.jfyg.cryptomarketcap.model.Currency

class RemoteDataRepositoryImpl() : DataRepository {
    override fun getCurrencies(jsonString: String): List<Currency> {
        TODO("eventually add remote datasource") //To change body of created functions use File | Settings | File Templates.
    }
}
