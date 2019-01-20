package currencies.jfyg.cryptomarketcap

import android.app.Application
import org.koin.android.ext.android.startKoin

class CryptoMarketCapApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(applicationModule, browseModule), loadProperties = true)
    }

}