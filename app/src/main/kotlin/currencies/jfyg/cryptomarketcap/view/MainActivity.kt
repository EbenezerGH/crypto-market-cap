package currencies.jfyg.cryptomarketcap.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import currencies.jfyg.cryptomarketcap.R
import currencies.jfyg.cryptomarketcap.data.DataRepository
import currencies.jfyg.cryptomarketcap.data.DataRepositoryFactory
import currencies.jfyg.cryptomarketcap.view.adapter.CurrenciesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val currenciesAdapter: CurrenciesAdapter by inject()
    val dataRepositoryFactory: DataRepositoryFactory by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupCurrenciesRecyclerView()

        val currenciesJson = resources.openRawResource(R.raw.currencies)
                .bufferedReader().use { it.readText() }

        val items = dataRepositoryFactory.retrieveLocalSource().getCurrencies(currenciesJson)
        currenciesAdapter.currencies = items
    }

    private fun setupCurrenciesRecyclerView() {
        rv_currencies.layoutManager = LinearLayoutManager(this)
        rv_currencies.adapter = currenciesAdapter
    }

}
