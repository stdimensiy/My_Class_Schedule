package com.vdvapp.myclassschedule.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.databinding.ItemHomeworkListTypeBinding

class HomeworkListViewHolder (
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemHomeworkListTypeBinding = ItemHomeworkListTypeBinding.inflate(li, parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    var title = binding.tvTitle
    var list = binding.rvHomework
}