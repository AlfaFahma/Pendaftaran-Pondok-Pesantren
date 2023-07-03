package com.ksatria.pendaftaranpondokpesantren.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ksatria.pendaftaranpondokpesantren.model.Registration
import com.ksatria.pendaftaranpondokpesantren.repository.RegistrationRepository
import kotlinx.coroutines.launch

class RegistrationViewModel(private val repository: RegistrationRepository): ViewModel() {
    val allRegistrations: LiveData<List<Registration>> = repository.allTires.asLiveData()

    fun insert(registration: Registration) = viewModelScope.launch {
        repository.InsertRegistration(registration)
    }

    fun delete(registration: Registration) = viewModelScope.launch {
        repository.DeleteRegistration(registration)
    }

    fun update(registration: Registration) = viewModelScope.launch {
        repository.UpdateRegistration(registration)
    }
}

class RegistrationViewModelFactory(private  val repository: RegistrationRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistrationViewModel::class.java)){
            return RegistrationViewModel(repository) as T
        }
        throw IllegalAccessException("Unknown viewModel class")
    }
}