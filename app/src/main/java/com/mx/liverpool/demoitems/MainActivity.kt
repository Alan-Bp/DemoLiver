package com.mx.liverpool.demoitems

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.mx.liverpool.demoitems.data.remote.ApiService
import com.mx.liverpool.demoitems.data.repository.ItemsRepository
import com.mx.liverpool.demoitems.databinding.ActivityMainBinding
import com.mx.liverpool.demoitems.presentation.adapter.ItemAptr
import com.mx.liverpool.demoitems.presentation.viewmodel.ItemViewModel
import com.mx.liverpool.demoitems.presentation.viewmodel.ItemViewModelFact
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var _binding: ActivityMainBinding;
    private var itemAdapter = ItemAptr(emptyList())

    @Inject
    lateinit var repository: ItemsRepository


    @Inject
    lateinit var apiService: ApiService
    private val itemViewModel: ItemViewModel by viewModels {
        ItemViewModelFact(repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        observeViewModel()
        setupRecyclerView()
        setupSearchEditText()
    }

    private fun observeViewModel() {
        itemViewModel.searchItems("", 1)
        itemViewModel.itemsResponse.observe(this) { productLivers ->
            productLivers?.let { records ->
                itemAdapter.setItems(records)
            }
        }
    }


    private fun setupRecyclerView() {
        _binding.rvProducts.layoutManager = LinearLayoutManager(this)
        _binding.rvProducts.adapter = itemAdapter
    }

    private fun setupSearchEditText() {
        _binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                s?.let {
                    if (it.isNotEmpty()) {
                        itemViewModel.searchItems(it.toString(), pageNumber = 1, sortPrice = null)
                    }
                }
            }
        })
    }
}