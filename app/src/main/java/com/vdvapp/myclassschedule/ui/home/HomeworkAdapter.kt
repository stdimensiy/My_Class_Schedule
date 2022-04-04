package com.vdvapp.myclassschedule.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.domain.Homework
import com.vdvapp.myclassschedule.ui.common.lists.ParticipantAdapter

class HomeworkAdapter : RecyclerView.Adapter<HomeworkViewHolder>() {
    var items: List<Homework> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeworkViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HomeworkViewHolder(layoutInflater, parent)
    }

    override fun onBindViewHolder(holder: HomeworkViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.lesson
        val hexColor =
            String.format("#%06X", 0xFFFFFF and holder.container.cardBackgroundColor.defaultColor)
        val participantAdapter = ParticipantAdapter(hexColor)
        holder.list.adapter = participantAdapter
        holder.list.layoutManager =
            LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
        participantAdapter.items = item.accomplices
    }

    override fun getItemCount(): Int {
        return items.size
    }
}