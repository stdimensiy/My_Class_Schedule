package com.vdvapp.myclassschedule.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.databinding.ItemTimerViewBinding

class TimerViewHolder(
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemTimerViewBinding = ItemTimerViewBinding.inflate(li, parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    private var daysTens = binding.tvTensDays
    private var daysOnes = binding.tvOnesDays
    private var hourseTens = binding.tvTensHours
    private var hourseOnes = binding.tvOnesHours
    private var minutesTens = binding.tvTensMinutes
    private var minutesOnes = binding.tvOnesMinutes
    private var title = binding.tvTitle

    fun setTitle(title: String) {
        this.title.text = title
    }

    fun setStartTime(title: String) {
        this.daysTens.text = "0"
        this.daysOnes.text = "0"
        this.hourseTens.text = "0"
        this.hourseOnes.text = "0"
        this.minutesTens.text = "0"
        this.minutesOnes.text = "0"
    }
}