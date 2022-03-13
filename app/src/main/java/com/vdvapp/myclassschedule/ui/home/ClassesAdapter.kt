package com.vdvapp.myclassschedule.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.ui.common.Lesson

class ClassesAdapter : RecyclerView.Adapter<ClassesViewHolder>() {
    var items: List<Lesson> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ClassesViewHolder(layoutInflater, parent)
    }

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
    }

    override fun getItemCount(): Int {
        return items.size
    }

}