package com.ksatria.pendaftaranpondokpesantren.repository

import com.ksatria.pendaftaranpondokpesantren.dao.RegistrationDao
import com.ksatria.pendaftaranpondokpesantren.model.Registration
import kotlinx.coroutines.flow.Flow

class RegistrationRepository(private val tireDao: RegistrationDao) {
    val allTires: Flow<List<Registration>> = tireDao.getAllTire()

    suspend fun InsertTire(tire: Registration){
        tireDao.InsertTire(tire)
    }
    suspend fun DeleteTire(tire: Registration){
        tireDao.DeleteTire(tire)
    }
    suspend fun UpdateTire(tire: Registration){
        tireDao.UpdateTire(tire)
    }
}