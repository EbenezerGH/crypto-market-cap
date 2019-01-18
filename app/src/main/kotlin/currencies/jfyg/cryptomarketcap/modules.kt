package currencies.jfyg.cryptomarketcap

import com.squareup.moshi.Moshi
import currencies.jfyg.cryptomarketcap.data.DataRepositoryImpl
import currencies.jfyg.cryptomarketcap.view.adapter.CurrenciesAdapter
import org.koin.dsl.module.module

val applicationModule = module {
    single { Moshi.Builder().build() }

    factory { CurrenciesAdapter() }
    factory { DataRepositoryImpl(Moshi.Builder().build()) }
}