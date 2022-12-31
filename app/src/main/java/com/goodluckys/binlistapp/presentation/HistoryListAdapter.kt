package com.goodluckys.binlistapp.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.goodluckys.binlistapp.databinding.CardBinding
import com.goodluckys.binlistapp.domain.CardInfo

class HistoryListAdapter :
    ListAdapter<CardInfo,HistoryListAdapter.CardListViewHolder>(CardInfoDiffCallback()) {

    var onClickListener: ((item: CardInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CardListViewHolder(CardBinding.inflate(inflater,parent,false))
    }

    override fun onBindViewHolder(holder: CardListViewHolder, position: Int) {
        val item = getItem(position)
        holder.onClickListener = onClickListener
        holder.bind(item)
    }

    class CardListViewHolder(val binding:CardBinding) : RecyclerView.ViewHolder(binding.root) {

        var onClickListener: ((item: CardInfo) -> Unit)? = null

        fun bind(item: CardInfo) {
            binding.tvBin.text = item.bin
            binding.tvScheme.text = item.scheme
            binding.root.setOnClickListener {
                onClickListener?.invoke(item)
            }
        }
    }

}



