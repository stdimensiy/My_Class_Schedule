package com.vdvapp.myclassschedule.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.databinding.ItemListUncnownTypeBinding

class UnknownTypeViewHolder (
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemListUncnownTypeBinding = ItemListUncnownTypeBinding.inflate(li, parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    var description = binding.tvDescription
}