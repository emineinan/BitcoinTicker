package com.example.bitcointicker.ui.detail

import android.util.Log
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.bitcointicker.base.BaseFragment
import com.example.bitcointicker.databinding.FragmentCoinDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CoinDetailFragment :
    BaseFragment<FragmentCoinDetailBinding, CoinDetailViewModel>(FragmentCoinDetailBinding::inflate) {
    override val viewModel by viewModels<CoinDetailViewModel>()
    private val args by navArgs<CoinDetailFragmentArgs>()

    override fun onCreateFinished() {
        args.coin.id?.let { viewModel.getDetail(it) }
    }

    override fun observeEvents() {
        with(viewModel) {
            detailResponse.observe(viewLifecycleOwner, {
                binding.coin = it
            })
            isLoading.observe(viewLifecycleOwner, {
                handleView(it)
            })
            onError.observe(viewLifecycleOwner, {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
                Log.e("HATA", "$it")
            })
        }

    }

    private fun handleView(isLoading: Boolean = false) {
        binding.detailGroup.isVisible = !isLoading
        binding.progressBarDetail.isVisible = isLoading
    }
}