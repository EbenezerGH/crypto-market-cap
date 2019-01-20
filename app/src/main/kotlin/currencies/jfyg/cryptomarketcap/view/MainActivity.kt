package currencies.jfyg.cryptomarketcap.view

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import currencies.jfyg.cryptomarketcap.R
import currencies.jfyg.cryptomarketcap.view.adapter.CurrenciesAdapter
import currencies.jfyg.cryptomarketcap.viewmodel.CurrenciesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope
import org.koin.android.scope.ext.android.getScope
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    val currenciesAdapter: CurrenciesAdapter by inject()
    val currenciesViewModel: CurrenciesViewModel by viewModel {
        val currenciesJson = resources.openRawResource(R.raw.currencies)
                .bufferedReader().use { it.readText() }

        // used to pass necessary argument of our constructor
        parametersOf(currenciesJson)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindScope(getOrCreateScope("browse"))
        setupCurrenciesRecyclerView()

        currenciesViewModel.observerCurrencies().observe(this, Observer {
            it?.let { currenciesAdapter.currencies = it }
        })

        currenciesViewModel.retrieveCurrencies()
    }

    override fun onDestroy() {
        getScope("browse").close()
        super.onDestroy()
    }

    private fun setupCurrenciesRecyclerView() {
        rv_currencies.layoutManager = LinearLayoutManager(this)
        rv_currencies.adapter = currenciesAdapter
    }

}
