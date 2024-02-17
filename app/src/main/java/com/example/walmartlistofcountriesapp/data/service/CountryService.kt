package com.example.walmartlistofcountriesapp.data.service

import com.example.walmartlistofcountriesapp.data.model.Country
import retrofit2.Response
import retrofit2.http.GET

interface CountryService {

    @GET("countries.json")
    suspend fun getCountry(): Response<List<Country>>
}