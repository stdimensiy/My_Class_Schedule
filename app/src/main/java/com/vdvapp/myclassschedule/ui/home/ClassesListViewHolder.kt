package com.vdvapp.myclassschedule.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.databinding.ItemClassesListTypeBinding

class ClassesListViewHolder(
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemClassesListTypeBinding = ItemClassesListTypeBinding.inflate(li, parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    var title = binding.tvTitle
    var list = binding.rvClasses
    var description = binding.tvComment
}