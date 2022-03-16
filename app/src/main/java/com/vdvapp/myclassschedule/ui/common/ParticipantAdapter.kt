package com.vdvapp.myclassschedule.ui.common

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ParticipantAdapter : RecyclerView.Adapter<ParticipantViewHolder>() {
    var items: List<Participable> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParticipantViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ParticipantViewHolder(layoutInflater, parent)
    }

    override fun onBindViewHolder(holder: ParticipantViewHolder, position: Int) {
        val item = items[position]
        // реализовать подстановку картинки аватара участника или ресурс
    }

    override fun getItemCount(): Int {
        return items.size
    }
}