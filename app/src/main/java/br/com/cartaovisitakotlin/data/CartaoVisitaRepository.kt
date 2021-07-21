package br.com.cartaovisitakotlin.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CartaoVisitaRepository(private val dao: CartaoVisitaDao) {
    fun insert(cartaoVisita: CartaoVisita) = runBlocking {
        launch(Dispatchers.IO) {
            dao.insert(cartaoVisita)
        }
    }

    fun getAll() = dao.getAll()
}