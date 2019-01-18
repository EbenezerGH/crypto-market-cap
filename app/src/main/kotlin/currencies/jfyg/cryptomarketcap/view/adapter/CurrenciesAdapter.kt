package currencies.jfyg.cryptomarketcap.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import currencies.jfyg.cryptomarketcap.model.Currency

class CurrenciesAdapter : RecyclerView.Adapter<CurrenciesAdapter.ViewHolder>() {

    var currencies: List<Currency> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO()
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        // val nameText: TextView = v.findViewById(R.id.tv_name)
        // val symbolText: TextView = v.findViewById(R.id.tv_symbol)
    }

}