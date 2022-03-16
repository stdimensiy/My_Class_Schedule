package com.vdvapp.myclassschedule.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.databinding.ItemParticipantBinding

class ParticipantViewHolder(
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemParticipantBinding = ItemParticipantBinding.inflate(li, parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    var participantImage = binding.ivParticipant
}