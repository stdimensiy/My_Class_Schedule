package com.vdvapp.myclassschedule.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.domain.Homework
import com.vdvapp.myclassschedule.ui.common.ParticipantAdapter

class HomeworkAdapter(val context: Context?) : RecyclerView.Adapter<HomeworkViewHolder>() {
    var items: List<Homework> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeworkViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HomeworkViewHolder(layoutInflater, parent)
    }

    override fun onBindViewHolder(holder: HomeworkViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.lesson
        var participantAdapter = ParticipantAdapter()
        holder.list.adapter = participantAdapter
        holder.list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        participantAdapter.items = item.accomplices
    }

    override fun getItemCount(): Int {
        return items.size
    }
}