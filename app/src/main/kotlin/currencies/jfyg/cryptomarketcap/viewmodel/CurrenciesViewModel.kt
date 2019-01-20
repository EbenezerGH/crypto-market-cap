package currencies.jfyg.cryptomarketcap.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import currencies.jfyg.cryptomarketcap.data.DataRepositoryFactory
import currencies.jfyg.cryptomarketcap.model.Currency

class CurrenciesViewModel constructor(
        private val dataRepositoryFactory: DataRepositoryFactory,
        private val jsonString: String) : ViewModel() {

    private val currencyLiveData = MutableLiveData<List<Currency>>()

    fun observerCurrencies(): LiveData<List<Currency>> {
        return currencyLiveData
    }

    fun retrieveCurrencies() {
        val data = dataRepositoryFactory.retrieveLocalSource().getCurrencies(jsonString)
        currencyLiveData.postValue(data)
    }

}