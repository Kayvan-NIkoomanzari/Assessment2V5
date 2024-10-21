package com.example.assessment2v5.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.assessment2v5.data.DashboardRepository
import com.example.assessment2v5.data.DashboardResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
//DashboardViewModel with Hilt Injection
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




