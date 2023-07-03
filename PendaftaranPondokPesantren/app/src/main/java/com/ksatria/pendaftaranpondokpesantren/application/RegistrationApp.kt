package com.ksatria.pendaftaranpondokpesantren.application

import android.app.Application
import com.ksatria.pendaftaranpondokpesantren.repository.RegistrationRepository

class RegistrationApp : Application() {
    val database by lazy { RegistrationDatabase.getDatabase(this) }
    val repository by lazy { RegistrationRepository(database.registrationDao()) }
}