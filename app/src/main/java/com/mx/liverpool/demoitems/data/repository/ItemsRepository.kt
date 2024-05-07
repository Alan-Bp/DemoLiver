package com.mx.liverpool.demoitems.data.repository

import ProductLiver
import android.util.Log
import com.mx.liverpool.demoitems.data.remote.ApiService
import mapProductRecordToProductLiver
import javax.inject.Inject

class ItemsRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun searchItems(
        searchString: String,
        pageNumber: Int,
        sortPrice: Int? = null
    ): List<ProductLiver>? {
        return try {
            val response = apiService.searchItems(searchString, pageNumber, sortPrice)
            if (response.isSuccessful) {
                val apiResponse = response.body()
                val refinements =
                    apiResponse?.plpResults?.records
                val products = refinements?.map { refinement ->
                    mapProductRecordToProductLiver(refinement)
                }
                return products
            } else {
                Log.e("ItemsRepository", "Error en la respuesta: ${response.errorBody()}")
                return null
            }
        } catch (e: Exception) {
            Log.e("ItemsRepository", "Excepción en la llamada a la API", e)
            return null
        }
    }
}
