package com.example.walmartlistofcountriesapp.data.source

import com.example.walmartlistofcountriesapp.data.model.Country
import retrofit2.Response

interface CountrySource {
    suspend fun getCountry(): Response<List<Country>>
}