package br.com.cartaovisitakotlin

import android.app.Application
import br.com.cartaovisitakotlin.data.CartaoVisitaRepository
import br.com.cartaovisitakotlin.data.AppDatabase


class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { CartaoVisitaRepository(database.cartaoDao()) }
}