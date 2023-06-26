package com.ksatria.pendaftaranpondokpesantren.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ksatria.pendaftaranpondokpesantren.model.Registration
import kotlinx.coroutines.flow.Flow


@Dao
interface RegistrationDao {
    @Query("SELECT * FROM tire_table ORDER BY name ASC")
    fun getAllTire(): Flow<List<Registration>>

    @Insert
    suspend fun InsertTire(tire: Registration)

    @Delete
    suspend fun DeleteTire(tire: Registration)

    @Update
    suspend fun UpdateTire(tire: Registration)
}