package com.example.assessment2v5.ui.dashboard

//import org.junit.jupiter.api.Assertions.*

//class DashboardViewModelTest


import android.util.Log
import com.example.assessment2v5.data.DashboardRepository
import com.example.assessment2v5.data.DashboardResponse
import com.example.assessment2v5.data.Entity // Make sure to import your Entity class
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DashboardViewModelTest {

    private lateinit var viewModel: DashboardViewModel
    private lateinit var repository: DashboardRepository

    private val exampleEntity = Entity(
        assetType = "Bond",
        ticker = "VBMFX",
        currentPrice = 10.75,
        dividendYield = 2.3,
        description = "Vanguard Total Bond Market Index Fund, providing broad exposure to U.S. investment-grade bonds."
    )

    // Make sure to pass all required parameters for DashboardResponse
    private val exampleDashboardResponse = DashboardResponse(
        entities = listOf(exampleEntity),
        entityTotal = 1 // Example value for entityTotal
    )

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        // Mock the repository
        repository = mockk()

        // Set the dispatcher for the ViewModel's scope
        Dispatchers.setMain(testDispatcher)

        // Mock the repository response
        coEvery { repository.getDashboardData(any()) } returns exampleDashboardResponse

        // Mock the Log class - this is required because we call Log.d in the ViewModel
        mockkStatic(Log::class)
        every { Log.d(any(), any()) } returns 0

        // Initialize the ViewModel
        viewModel = DashboardViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Reset the Main dispatcher to the original one
    }

    @Test
    fun `test ViewModel calls API and updates dashboardData on fetch`() = runTest(testDispatcher) {
        // Call the method to fetch data
        viewModel.getDashboardData("valid_keypass")

        // Advance time to allow the ViewModel's coroutine to execute
        advanceUntilIdle()

        // Verify that the dashboardData is updated with the mocked data
        val dashboardData = viewModel.dashboardData.value
        assertNotNull(dashboardData) // Check that the dashboard data is not null
        assertEquals(1, dashboardData?.entities?.size) // Verify there's one entity
        assertEquals("Bond", dashboardData?.entities?.first()?.assetType) // Verify assetType
        assertEquals("VBMFX", dashboardData?.entities?.first()?.ticker) // Verify ticker
        assertEquals(10.75, dashboardData?.entities?.first()?.currentPrice ?: 0.0, 0.001) // Handle nullable currentPrice
        assertEquals(2.3, dashboardData?.entities?.first()?.dividendYield ?: 0.0, 0.001) // Handle nullable dividendYield
        assertEquals("Vanguard Total Bond Market Index Fund, providing broad exposure to U.S. investment-grade bonds.",
            dashboardData?.entities?.first()?.description) // Verify description
    }
}
