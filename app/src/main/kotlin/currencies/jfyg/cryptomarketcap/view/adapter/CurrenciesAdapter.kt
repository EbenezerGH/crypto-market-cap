package currencies.jfyg.cryptomarketcap.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import currencies.jfyg.cryptomarketcap.model.Currency
import currencies.jfyg.cryptomarketcap.R
import currencies.jfyg.cryptomarketcap.view.CurrencyView

class CurrenciesAdapter : RecyclerView.Adapter<CurrenciesAdapter.ViewHolder>() {

    var currencies: List<Currency> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_currency, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int =
            currencies.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.currencyView.setCurrency(currencies[position])
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val currencyView: CurrencyView = v.findViewById(R.id.view_currency)
    }

}