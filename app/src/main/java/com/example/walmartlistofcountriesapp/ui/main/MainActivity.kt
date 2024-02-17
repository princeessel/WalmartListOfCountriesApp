package com.example.walmartlistofcountriesapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.walmartlistofcountriesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val countriesAdapter = CountryAdapter()

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initUi()
        initObservers()
    }

    private fun initUi() {
        binding.countriesRecycleview.adapter = countriesAdapter
        binding.countriesRecycleview.layoutManager = LinearLayoutManager(this)
    }

    private fun initObservers() {
        viewModel.countries.observe(this) {
            it.data?.let {data ->
                countriesAdapter.setCountries(data)
            }
        }

        viewModel.uiState.observe(this) { state ->
            binding.countriesRecycleview.isVisible = false
            binding.progressBar.isVisible = false
            when {
                state.loading -> {
                    binding.progressBar.isVisible = true
                }

                state.error != null -> {
                    Toast.makeText(this@MainActivity, state.error, Toast.LENGTH_SHORT).show()
                }

                state.countries != null -> {
                    binding.countriesRecycleview.isVisible = true
                }
            }
        }
    }
}