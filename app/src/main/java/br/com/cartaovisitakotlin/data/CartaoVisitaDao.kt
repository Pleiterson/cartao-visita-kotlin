package br.com.cartaovisitakotlin.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CartaoVisitaDao {
    @Query("SELECT * FROM CartaoVisita")
    fun getAll(): LiveData<List<CartaoVisita>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(cartaoVisita: CartaoVisita)
}