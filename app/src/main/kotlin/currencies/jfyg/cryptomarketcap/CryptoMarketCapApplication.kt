package currencies.jfyg.cryptomarketcap

import android.app.Application
import org.koin.android.ext.android.startKoin
import timber.log.Timber

class CryptoMarketCapApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        startKoin(this,
                listOf(applicationModule, browseModule),
                loadProperties = true,
                logger = KoinLogger())
    }

}