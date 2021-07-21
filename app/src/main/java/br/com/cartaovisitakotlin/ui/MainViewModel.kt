package br.com.cartaovisitakotlin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.cartaovisitakotlin.data.CartaoVisita
import br.com.cartaovisitakotlin.data.CartaoVisitaRepository

class MainViewModel(private val cartaoVisitaRepository: CartaoVisitaRepository): ViewModel() {
    fun insert(cartaoVisita: CartaoVisita) {
        cartaoVisitaRepository.insert(cartaoVisita)
    }

    fun getAll(): LiveData<List<CartaoVisita>> {
        return cartaoVisitaRepository.getAll()
    }
}

class MainViewModelFactory(private val repository: CartaoVisitaRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}