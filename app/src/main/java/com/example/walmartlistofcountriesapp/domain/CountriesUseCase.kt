package com.example.walmartlistofcountriesapp.domain

import Resource
import com.example.walmartlistofcountriesapp.data.repository.CountryRepository
import com.example.walmartlistofcountriesapp.data.model.Country

class CountriesUseCase(
    private val countryRepository: CountryRepository
) {
    suspend fun execute(): Resource<List<Country>> = countryRepository.getCountry().let {
        if (it.isSuccessful) {
            Resource.success(it.body())
        } else {
            Resource.error(it.errorBody()?.string())
        }
    }
}
