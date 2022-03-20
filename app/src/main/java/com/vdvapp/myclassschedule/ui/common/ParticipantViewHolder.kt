package com.vdvapp.myclassschedule.ui.common

import android.graphics.Color
import android.graphics.drawable.LayerDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.R
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
            (container.layoutParams as MarginLayoutParams).marginStart = 0
            container.requestLayout()
        }
    }

    fun setImageAvatar(s: String) {
        //TODO("Not yet implemented")
    }

    fun setImageBackground(customizableColor: String, cardBackgroundColor: String) {
        val layerDrawable = participantImage.background as LayerDrawable
        layerDrawable.findDrawableByLayerId(R.id.base_background)
            .setTint(Color.parseColor(customizableColor))
        layerDrawable.findDrawableByLayerId(R.id.ring)
            .setTint(Color.parseColor(cardBackgroundColor))
    }


}