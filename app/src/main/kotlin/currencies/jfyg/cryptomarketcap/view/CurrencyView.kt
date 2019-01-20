package currencies.jfyg.cryptomarketcap.view

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import currencies.jfyg.cryptomarketcap.R
import currencies.jfyg.cryptomarketcap.UrlHelper
import currencies.jfyg.cryptomarketcap.model.Currency
import kotlinx.android.synthetic.main.view_currency.view.*
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class CurrencyView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0) : LinearLayout(context, attrs, defStyleAttr), KoinComponent {

    val urlHelper: UrlHelper by inject()

    init {
        View.inflate(context, R.layout.view_currency, this)
    }

    fun setCurrency(currency: Currency) {
        tv_name.text = currency.name
        tv_symbol.text = currency.symbol

        setOnClickListener {
            urlHelper.launchUrl(context, Uri.parse("https://coinmarketcap.com/currencies/${currency.slug}"))
        }
    }

}