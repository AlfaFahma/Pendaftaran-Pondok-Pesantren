package com.ksatria.pendaftaranpondokpesantren.repository

import com.ksatria.pendaftaranpondokpesantren.dao.RegistrationDao
import com.ksatria.pendaftaranpondokpesantren.model.Registration
import kotlinx.coroutines.flow.Flow

class RegistrationRepository(private val registrationDao: RegistrationDao) {
    val allTires: Flow<List<Registration>> = registrationDao.getAllTire()

    suspend fun InsertRegistration(registration: Registration){
        registrationDao.InsertTire(registration)
    }
    suspend fun DeleteRegistration(registration: Registration){
        registrationDao.DeleteTire(registration)
    }
    suspend fun UpdateRegistration(registration: Registration){
        registrationDao.UpdateTire(registration)
    }
}