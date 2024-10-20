package com.example.assessment2v5.ui.dashboard



//import androidx.hilt.lifecycle.ViewModelInject

/*
class DashboardViewModel @ViewModelInject constructor(
    private val repository: DashboardRepository
) : ViewModel() {

    private val _dashboardData = MutableStateFlow<DashboardResponse?>(null)
    val dashboardData: StateFlow<DashboardResponse?> get() = _dashboardData

    private val _titleText = MutableStateFlow("Dashboard")
    val titleText: StateFlow<String> get() = _titleText

    fun getDashboardData(keypass: String) {
        viewModelScope.launch {
            try {
                val data = repository.getDashboardData(keypass)
                _dashboardData.value = data
            } catch (e: Exception) {
                e.printStackTrace()
                _dashboardData.value = null
            }
        }
    }
}
*/


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment2v5.data.DashboardRepository
import com.example.assessment2v5.data.DashboardResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: DashboardRepository
) : ViewModel() {

    // StateFlow to hold the dashboard data
    private val _dashboardData = MutableStateFlow<DashboardResponse?>(null)
    val dashboardData: StateFlow<DashboardResponse?> get() = _dashboardData

    // Optional title text exposed as StateFlow
    private val _titleText = MutableStateFlow("Dashboard")
    val titleText: StateFlow<String> get() = _titleText

    // Fetch data from the Repository
    fun getDashboardData(keypass: String) {
        viewModelScope.launch {
            try {
                // Fetch data from repository
                val data = repository.getDashboardData(keypass)
                _dashboardData.value = data
            } catch (e: Exception) {
                e.printStackTrace()
                _dashboardData.value = null
            }
        }
    }
}





/*This code works with login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment2v5.data.DashboardRepository
import com.example.assessment2v5.data.DashboardResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: DashboardRepository) : ViewModel() {
   // constructor() : this(DashboardRepository())
    // StateFlow to hold the dashboard data
    private val _dashboardData = MutableStateFlow<DashboardResponse?>(null)
    val dashboardData: StateFlow<DashboardResponse?> get() = _dashboardData

    // Optional title text exposed as StateFlow
    private val _titleText = MutableStateFlow("Dashboard")
    val titleText: StateFlow<String> get() = _titleText

    // Fetch data from the Repository
    fun getDashboardData(keypass: String) {
        viewModelScope.launch {
            try {
                // Fetch data from repository
                val data = repository.getDashboardData(keypass)
                _dashboardData.value = data
            } catch (e: Exception) {
                e.printStackTrace()
                _dashboardData.value = null
            }
        }
    }
}
*/

