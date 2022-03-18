package com.vdvapp.myclassschedule.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.databinding.ItemParticipantBinding


class ParticipantViewHolder(
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemParticipantBinding = ItemParticipantBinding.inflate(li, parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    private var participantImage = binding.ivParticipant
    private var container = binding.clParticipant

    fun makeAnIndent() {
        if (container.layoutParams is MarginLayoutParams) {
            (container.layoutParams as MarginLayoutParams).marginStart = -10
            container.requestLayout()
        }
    }

    fun setImageAvatar(s: String) {
        //TODO("Not yet implemented")
    }

    fun setImageBackground(systemBackground: String) {
        //TODO("Not yet implemented")
    }


}