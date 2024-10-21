package com.example.assessment2v5.ui.dashboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.assessment2v5.R
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.coroutines.launch
import android.widget.TextView
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import com.example.assessment2v5.data.Entity
@AndroidEntryPoint
//DashboardFragment with Hilt Injection
class DashboardFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by viewModels()

    private lateinit var entityAdapter: EntityAdapter
    private lateinit var navigationFunction: (Entity) -> Unit

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the navigation function similar to the example
      /*  navigationFunction = { entity ->
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailsFragment(entity.description)
            findNavController().navigate(action)
        }*/
        navigationFunction = { entity ->
            val description = entity.description ?: "No description available"
            val action = DashboardFragmentDirections.actionDashboardFragmentToDetailsFragment(description)
            findNavController().navigate(action)
        }

        // Initialize RecyclerView Adapter with navigation function
        entityAdapter = EntityAdapter(mutableListOf(), navigationFunction)

        // Set up RecyclerView
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = entityAdapter
        }

        // Fetch and observe data using repeatOnLifecycle
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                dashboardViewModel.dashboardData.collect { dashboardResponse ->
                    if (dashboardResponse != null) {
                        entityAdapter.setData(dashboardResponse.entities)
                    } else {
                        Toast.makeText(requireContext(), "Failed to load data", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        // Fetch data if a valid keypass is provided
        val keypass = arguments?.getString("keypass") ?: ""
        if (keypass.isNotEmpty()) {
            fetchDashboardData(keypass)
        } else {
            Toast.makeText(requireContext(), "Invalid keypass", Toast.LENGTH_SHORT).show()
        }
    }

    private fun fetchDashboardData(keypass: String) {
        // Trigger fetching data from ViewModel
        lifecycleScope.launch {
            dashboardViewModel.getDashboardData(keypass)
        }
    }
}










