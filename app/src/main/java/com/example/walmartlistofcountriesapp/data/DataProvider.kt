package com.example.walmartlistofcountriesapp.data

import com.example.walmartlistofcountriesapp.data.network.RestApi
import com.example.walmartlistofcountriesapp.data.repository.CountryRepository
import com.example.walmartlistofcountriesapp.data.service.CountryService
import com.example.walmartlistofcountriesapp.data.source.CountrySource
import com.example.walmartlistofcountriesapp.data.source.CountrySourceImpl

object DataProvider {
    fun provideCountryService(): CountryService = RestApi.getCountriesResultInstance()

    fun provideCountryRepository(): CountryRepository = CountryRepository(
        countrySource = provideCountrySource()
    )

    fun provideCountrySource(): CountrySource = CountrySourceImpl(
        countryService = provideCountryService()
    )
}