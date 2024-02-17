package com.example.walmartlistofcountriesapp.data.repository

import com.example.walmartlistofcountriesapp.data.source.CountrySource

class CountryRepository(
    private val countrySource: CountrySource
) {
    suspend fun getCountry() = countrySource.getCountry()
}