package com.example.walmartlistofcountriesapp.ui.main

import Resource
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.walmartlistofcountriesapp.domain.CountriesUseCase
import com.example.walmartlistofcountriesapp.data.model.Country
import com.example.walmartlistofcountriesapp.data.model.Status
import com.example.walmartlistofcountriesapp.domain.DomainProvider
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val countriesUseCase: CountriesUseCase = DomainProvider.provideCountriesUseCase()

    private val _countries = MutableLiveData<Resource<List<Country>>>()
    val countries: LiveData<Resource<List<Country>>> = _countries

    private val _uiState = MutableLiveData<UiState>(UiState())
    val uiState: LiveData<UiState> = _uiState

    init {
        getCountries()
    }

    private fun getCountries() {
        _uiState.value = UiState(
            loading = true
        )
        viewModelScope.launch {
            countriesUseCase.execute().let {
                if (it.status == Status.SUCCESS) {
                    _uiState.value = UiState(
                        countries = it.data
                    )
                    _countries.value = Resource.success(it.data)
                } else {
                    _uiState.value = UiState(
                        error = it.message
                    )
                }
            }
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val error: String? = null,
        val countries: List<Country>? = null,
    )
}