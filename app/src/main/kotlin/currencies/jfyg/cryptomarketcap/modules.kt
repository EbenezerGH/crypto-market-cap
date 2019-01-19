package currencies.jfyg.cryptomarketcap


import com.google.gson.Gson
import currencies.jfyg.cryptomarketcap.data.DataRepository
import currencies.jfyg.cryptomarketcap.data.DataRepositoryImpl
import currencies.jfyg.cryptomarketcap.view.adapter.CurrenciesAdapter
import org.koin.dsl.module.module

val applicationModule = module {
    single { Gson() }
    factory { CurrenciesAdapter() }
    factory<DataRepository> { DataRepositoryImpl(get()) }
}