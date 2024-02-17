package com.example.walmartlistofcountriesapp.domain

import com.example.walmartlistofcountriesapp.data.DataProvider

object DomainProvider {
    fun provideCountriesUseCase(): CountriesUseCase = CountriesUseCase(
        countryRepository = DataProvider.provideCountryRepository()
    )
}