package currencies.jfyg.cryptomarketcap


import com.google.gson.Gson
import currencies.jfyg.cryptomarketcap.data.DataRepository
import currencies.jfyg.cryptomarketcap.data.DataRepositoryFactory
import currencies.jfyg.cryptomarketcap.data.LocalDataRepositoryImpl
import currencies.jfyg.cryptomarketcap.data.RemoteDataRepositoryImpl
import currencies.jfyg.cryptomarketcap.view.adapter.CurrenciesAdapter
import currencies.jfyg.cryptomarketcap.viewmodel.CurrenciesViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val applicationModule = module {
    single { Gson() }
    single { UrlHelper() }

    factory { CurrenciesAdapter() }

    factory<DataRepository>("local") { LocalDataRepositoryImpl(get()) }
    factory<DataRepository>("remote") { RemoteDataRepositoryImpl() }
    factory { DataRepositoryFactory(get("local"), get("remote")) }

    viewModel { CurrenciesViewModel(get()) }
}