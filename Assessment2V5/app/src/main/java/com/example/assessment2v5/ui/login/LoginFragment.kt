package com.example.assessment2v5.ui.login
/*
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.assessment2v5.R
import android.widget.Toast
import androidx.fragment.app.viewModels

import androidx.lifecycle.lifecycleScope
import com.example.assessment2v5.data.LoginRequest
import com.example.assessment2v5.databinding.FragmentLoginBinding
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty()) {
                login(username, password)
            } else {
                Toast.makeText(requireContext(), "Please enter valid credentials", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun login(username: String, password: String) {
        val loginRequest = LoginRequest(username, password)

        lifecycleScope.launch {
            val result = loginViewModel.login(loginRequest)
            if (result != null) {
                // Login successful, navigate to the next screen
                Toast.makeText(requireContext(), "Login successful!", Toast.LENGTH_SHORT).show()
                // Use Navigation component to navigate to Dashboard
                // findNavController().navigate(R.id.action_loginFragment_to_dashboardFragment)
            } else {
                Toast.makeText(requireContext(), "Login failed", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
*/
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.assessment2v5.R
import com.example.assessment2v5.ui.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameEditText: EditText = view.findViewById(R.id.etUsername)
        val passwordEditText: EditText = view.findViewById(R.id.etPassword)
        val loginButton: Button = view.findViewById(R.id.btnLogin)

        // Set up the login button click listener
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Call the login function in the ViewModel
            loginViewModel.login(username, password)
        }

        // Observe the login result
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                loginViewModel.loginResult.collect { result ->
                    if (result.isSuccess) {
                        val keypass = result.getOrNull()
                        keypass?.let {
                            // Navigate to the dashboard with the keypass
                            val action = LoginFragmentDirections.actionLoginFragmentToDashboardFragment(keypass)
                            findNavController().navigate(action)
                        }
                    } else {
                        // Show an error message
                        Toast.makeText(requireContext(), "Login failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

