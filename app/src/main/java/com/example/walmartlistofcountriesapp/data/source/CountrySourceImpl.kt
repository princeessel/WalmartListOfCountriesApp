package com.example.walmartlistofcountriesapp.data.source

import com.example.walmartlistofcountriesapp.data.service.CountryService
import com.example.walmartlistofcountriesapp.data.model.Country
import retrofit2.Response

class CountrySourceImpl(
    private val countryService: CountryService
) : CountrySource {
    override suspend fun getCountry(): Response<List<Country>> = countryService.getCountry()
}