package com.mx.liverpool.demoitems.presentation.viewmodel

import ProductLiver
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mx.liverpool.demoitems.data.repository.ItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val repository: ItemsRepository) : ViewModel() {

    private val _loading = MutableLiveData<Boolean>()

    private val _itemsResponse = MutableLiveData<List<ProductLiver>>()
    val itemsResponse: LiveData<List<ProductLiver>> get() = _itemsResponse

    fun searchItems(searchString: String, pageNumber: Int, sortPrice: Int? = null) {
        viewModelScope.launch {
            try {
                _loading.value = true
                val response = repository.searchItems(searchString, pageNumber, sortPrice)
                _itemsResponse.value = response
                Log.d("ItemViewModel", "Respuesta de la API: $response")
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _loading.value = false
            }
        }
    }
}

