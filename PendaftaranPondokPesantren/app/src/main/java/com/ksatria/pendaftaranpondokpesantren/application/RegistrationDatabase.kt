package com.ksatria.pendaftaranpondokpesantren.application

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ksatria.pendaftaranpondokpesantren.dao.RegistrationDao
import com.ksatria.pendaftaranpondokpesantren.model.Registration

@Database(entities = [Registration::class], version = 1, exportSchema = false)
abstract class RegistrationDatabase: RoomDatabase() {
    abstract fun registrationDao(): RegistrationDao

    companion object{
        private var INSTANCE: RegistrationDatabase? = null

        fun getDatabase(context: Context): RegistrationDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RegistrationDatabase::class.java,
                    "registration_database"
                )
                    .allowMainThreadQueries()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }

}