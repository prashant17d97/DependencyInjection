package com.prashant.dependecyinjection

import androidx.lifecycle.ViewModel
import com.prashant.dependecyinjection.apicallings.ApiService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(val apiService: ApiService) : ViewModel() {

    val name = "Prashant Kumar Singh"
}