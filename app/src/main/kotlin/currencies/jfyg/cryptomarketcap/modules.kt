package currencies.jfyg.cryptomarketcap


import com.google.gson.Gson
import currencies.jfyg.cryptomarketcap.data.DataRepository
import currencies.jfyg.cryptomarketcap.data.DataRepositoryFactory
import currencies.jfyg.cryptomarketcap.data.LocalDataRepositoryImpl
import currencies.jfyg.cryptomarketcap.data.RemoteDataRepositoryImpl
import currencies.jfyg.cryptomarketcap.view.adapter.CurrenciesAdapter
import org.koin.dsl.module.module

val applicationModule = module {
    single { Gson() }
    factory { CurrenciesAdapter() }
    factory<DataRepository>("local") { LocalDataRepositoryImpl(get()) }
    factory<DataRepository>("remote") { RemoteDataRepositoryImpl() }

    factory { DataRepositoryFactory(get("local"), get("remote")) }
}