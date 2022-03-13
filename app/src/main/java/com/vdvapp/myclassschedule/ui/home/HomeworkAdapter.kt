package com.vdvapp.myclassschedule.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.domain.Homework

class HomeworkAdapter : RecyclerView.Adapter<HomeworkViewHolder>() {
    var items: List<Homework> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeworkViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HomeworkViewHolder(layoutInflater, parent)
    }

    override fun onBindViewHolder(holder: HomeworkViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.lesson
    }

    override fun getItemCount(): Int {
        return items.size
    }
}