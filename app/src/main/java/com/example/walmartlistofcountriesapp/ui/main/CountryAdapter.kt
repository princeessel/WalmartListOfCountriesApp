package com.example.walmartlistofcountriesapp.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.walmartlistofcountriesapp.R
import com.example.walmartlistofcountriesapp.databinding.CountriesRowItemBinding
import com.example.walmartlistofcountriesapp.data.model.Country

class CountryAdapter : RecyclerView.Adapter<CountryAdapter.ViewHolder>() {
    private var countries = listOf<Country>()

    @SuppressLint("NotifyDataSetChanged")
    fun setCountries(countries: List<Country>) {
        this.countries = countries
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            CountriesRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countries[position]
        holder.bind(country)
    }

    override fun getItemCount(): Int = countries.size

    inner class ViewHolder(private val itemBinding: CountriesRowItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(country: Country) {
            itemBinding.countryName.text = itemBinding.countryName.context.getString(R.string.country_and_region, country.name, country.region)
            itemBinding.code.text = country.code
            itemBinding.capital.text = country.capital
        }
    }
}
