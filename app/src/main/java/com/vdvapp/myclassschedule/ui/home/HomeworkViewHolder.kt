package com.vdvapp.myclassschedule.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.databinding.ItemHomeworkBinding

class HomeworkViewHolder (
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemHomeworkBinding = ItemHomeworkBinding.inflate(li, parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    var title = binding.tvDiscipline
    var list = binding.rvAccomplices
}