package com.goodluckys.binlistapp.presentation

import androidx.recyclerview.widget.DiffUtil
import com.goodluckys.binlistapp.domain.CardInfo

class CardInfoDiffCallback : DiffUtil.ItemCallback<CardInfo>() {
    override fun areItemsTheSame(oldItem: CardInfo, newItem: CardInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CardInfo, newItem: CardInfo): Boolean {
        return oldItem == newItem
    }

}
