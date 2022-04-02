package com.vdvapp.myclassschedule.ui.classes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.ui.common.Lesson
import com.vdvapp.myclassschedule.ui.common.ClassesViewHolder
import com.vdvapp.myclassschedule.ui.common.ParticipantAdapter

class ClassesFragmentAdapter : RecyclerView.Adapter<ClassesViewHolder>() {
    var items: List<Lesson> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ClassesViewHolder(layoutInflater, parent)
    }

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.comment.text = "${item.timeStart} - ${item.timeEnd}"
        if(position > 0) holder.setSmallTimePoint()
        if (item.isOpenInSkype) holder.showLink()
        if (item.isAdditionalLesson) holder.makeItSpecial()
        if (item.annotation != "") holder.showDescription(item.annotation)
        else holder.hideDescription()
        if (item.participants.isNotEmpty()){
            holder.showAccomplices()
            val hexColor =
                String.format("#%06X", 0xFFFFFF and holder.lessonContainer.cardBackgroundColor.defaultColor)
            val participantAdapter = ParticipantAdapter(hexColor)
            holder.accomplices.adapter = participantAdapter
            holder.accomplices.layoutManager = LinearLayoutManager(holder.itemView.context, LinearLayoutManager.HORIZONTAL, false)
            participantAdapter.items = item.participants
        }
        else holder.hideAccomplices()
        holder.showDescriptionIcon()
        holder.showVerticalDivider()
        holder.setTimeInterval(item.timeStart, item.timeEnd)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}