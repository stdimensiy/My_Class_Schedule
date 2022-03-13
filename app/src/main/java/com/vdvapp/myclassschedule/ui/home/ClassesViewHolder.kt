package com.vdvapp.myclassschedule.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.databinding.ItemClassesSimpleTypeBinding

class ClassesViewHolder(
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemClassesSimpleTypeBinding = ItemClassesSimpleTypeBinding.inflate(li, parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    var title = binding.tvName
}