package com.example.bitcointicker.ui.login

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.bitcointicker.base.BaseFragment
import com.example.bitcointicker.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding, LoginViewModel>(
    FragmentLoginBinding::inflate
) {
    override val viewModel by viewModels<LoginViewModel>()

    override fun onCreateFinished() {
        binding.buttonLogin.setOnClickListener {
            viewModel.login(
                binding.editTextEmail.text.toString(),
                binding.editTextPassword.text.toString()
            )
        }
    }

    override fun observeEvents() {
        viewModel.isLogin.observe(viewLifecycleOwner, {
            if (it) {
                val action = LoginFragmentDirections.actionLoginFragmentToListFragment()
                Navigation.findNavController(requireView()).navigate(action)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Please enter a valid email and password.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }

}