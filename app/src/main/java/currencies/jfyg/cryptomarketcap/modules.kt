package currencies.jfyg.cryptomarketcap

import com.squareup.moshi.Moshi
import org.koin.dsl.module.module

val applicationModule = module {
    single {  }
    single { Moshi.Builder().build() }

}