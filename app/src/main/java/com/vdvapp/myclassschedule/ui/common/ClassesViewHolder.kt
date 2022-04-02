package com.vdvapp.myclassschedule.ui.common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.R
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
    private var headerTitle = binding.tvTimeInterval
    private var timeInterval = binding.tvTimeInterval
    private val lLink = binding.llLink
    private val lessonContainer = binding.clLesson
    private val description = binding.tvDescription
    private val accomplices = binding.rvAccomplices


    fun setDescriptionIcon(res: Int) {
        descriptionIcon.setImageResource(res)
    }

    fun setTimeInterval(start: String, stop: String) {
        "$start - $stop".also { timeInterval.text = it }
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
        headerTitle.visibility = View.GONE
    }

    fun hideLink() {
        lLink.visibility = View.GONE
    }

    fun showLink() {
        lLink.visibility = View.VISIBLE
    }

    fun showDescription(text: String) {
        description.visibility = View.VISIBLE
        description.text = text
    }

    fun hideDescription() {
        description.visibility = View.GONE
    }

    fun showAccomplices() {
        accomplices.visibility = View.VISIBLE
    }

    fun hideAccomplices() {
        accomplices.visibility = View.GONE
    }

    fun makeItSpecial() {
        lessonContainer.setBackgroundResource(R.drawable.background_for_card_gradient)
    }
}