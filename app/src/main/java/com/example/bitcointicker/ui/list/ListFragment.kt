package com.example.bitcointicker.ui.list

import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.bitcointicker.base.BaseFragment
import com.example.bitcointicker.databinding.FragmentListBinding
import com.example.bitcointicker.model.list.Coin
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : BaseFragment<FragmentListBinding, ListViewModel>(
    FragmentListBinding::inflate
) {
    override val viewModel by viewModels<ListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getData()
    }

    override fun observeEvents() {
        with(viewModel) {
            coinResponse.observe(viewLifecycleOwner, {
                setRecyclerView(it!!)
            })
            isLoading.observe(viewLifecycleOwner, {
                handleViews(it)
            })

            onError.observe(viewLifecycleOwner, {
                Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
            })
        }
    }

    private fun setRecyclerView(data: List<Coin>) {
        val homeAdapter = ListAdapter(object : ItemClickListener {
            override fun onItemClick(coin: Coin) {
                if (coin.symbol != null) {
                    val action = ListFragmentDirections.actionListFragmentToCoinDetailFragment(coin)
                    Navigation.findNavController(requireView()).navigate(action)
                }
            }
        })
        binding.recyclerViewHome.adapter = homeAdapter
        homeAdapter.setList(data)
    }

    private fun handleViews(isLoading: Boolean = false) {
        binding.recyclerViewHome.isVisible = !isLoading
        binding.progressBarHome.isVisible = isLoading
    }

    override fun onCreateFinished() {
    }
}