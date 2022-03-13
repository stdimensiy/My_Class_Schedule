package com.vdvapp.myclassschedule.ui.home

import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.databinding.ItemClassesSimpleTypeBinding

class ClassesViewHolder(
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemClassesSimpleTypeBinding = ItemClassesSimpleTypeBinding.inflate(li, parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    var title = binding.tvName
    var comment = binding.tvComment
    private var descriptionIcon = binding.ivDescriptionIcon
    private var divider = binding.divider
    private var headerPoint = binding.ivTimePoint
    private var headetTitle = binding.tvTime

    fun setDescriptionIcon(res: Int) {
        descriptionIcon.setImageResource(res)
    }

    fun hideDescriptionIcon() {
        descriptionIcon.visibility = View.GONE
    }

    fun showDescriptionIcon() {
        descriptionIcon.visibility = View.VISIBLE
    }

    fun hideVerticalDivider() {
        divider.visibility = View.GONE
    }

    fun showVerticalDivider() {
        divider.visibility = View.VISIBLE
    }

    fun hideTimePoint() {
        headerPoint.visibility = View.GONE
    }

    fun hideItemHeader() {
        headetTitle.visibility = View.GONE
    }
}