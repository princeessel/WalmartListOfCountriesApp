package com.example.walmartlistofcountriesapp.data.network

import com.example.walmartlistofcountriesapp.Constants.BASE_URL
import com.example.walmartlistofcountriesapp.data.service.CountryService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestApi {
    companion object {
        private lateinit var countryService: CountryService

        fun getCountriesResultInstance(): CountryService {
            if (!this::countryService.isInitialized) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                countryService = retrofit.create(CountryService::class.java)
            }
            return countryService
        }
    }
}
