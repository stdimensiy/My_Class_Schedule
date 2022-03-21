package com.vdvapp.myclassschedule.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.domain.User

class ParticipantAdapter(var cardBackgroundColor: String) :
    RecyclerView.Adapter<ParticipantViewHolder>() {
    var items: List<Participable> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipantViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ParticipantViewHolder(layoutInflater, parent)
    }

    override fun onBindViewHolder(holder: ParticipantViewHolder, position: Int) {
        val item = items[position]
        if (position == 0) holder.makeAnIndent()
        when (item) {
            is User -> {
                holder.setImageBackground(item.systemBackground, cardBackgroundColor)
                holder.setImageAvatar(item.customAvatar ?: item.systemAvatar)
            }
        }
        // на будущее, необходимо реализовать логику отработки клика на элементе
    }

    override fun getItemCount(): Int {
        return items.size
    }
}