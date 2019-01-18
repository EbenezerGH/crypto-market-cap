package currencies.jfyg.cryptomarketcap.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import currencies.jfyg.cryptomarketcap.model.Currency
import currencies.jfyg.cryptomarketcap.R

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
        val currency = currencies[position]
        holder.nameText.text = currency.name
        holder.symbolText.text = currency.symbol
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val nameText: TextView = v.findViewById(R.id.tv_name)
        val symbolText: TextView = v.findViewById(R.id.tv_symbol)
    }

}