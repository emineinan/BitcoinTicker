package com.example.bitcointicker.ui.list


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bitcointicker.databinding.RowItemBinding
import com.example.bitcointicker.model.list.Coin

class ListAdapter(private val listener: ItemClickListener) :
    RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var coins = emptyList<Coin>()

    class MyViewHolder(private val binding: RowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: ItemClickListener, coin: Coin) {
            binding.onItemClickListener = listener
            binding.coin = coin
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RowItemBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder.from(parent)

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(listener, coins[position])

    override fun getItemCount() = coins.size

    fun setList(newList: List<Coin>) {
        coins = newList
        notifyDataSetChanged()
    }
}