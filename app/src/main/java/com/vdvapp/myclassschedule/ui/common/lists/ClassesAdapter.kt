package com.vdvapp.myclassschedule.ui.common.lists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.ui.common.Lesson
import com.vdvapp.myclassschedule.ui.common.ListView

class ClassesAdapter(val typeListView: ListView) :
    RecyclerView.Adapter<ClassesViewHolder>() {
    var items: List<Lesson> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ClassesViewHolder(layoutInflater, parent)
    }

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        val item = items[position]
        // общие для любого типа разметки элемента данные
        holder.title.text = item.title
        if (item.isOpenInSkype) holder.showLink()
        if (item.isAdditionalLesson) holder.makeItSpecial()
        holder.showDescriptionIcon()
        // при полном отображении разметки: режим FULL
        if (typeListView == ListView.FULL) {
            holder.comment.text = item.Teacher
            holder.showTimePoint()
            holder.showItemHeader()
            if (position > 0) holder.setSmallTimePoint()
            if (item.annotation != "") holder.showDescription(item.annotation)
            if (item.participants.isNotEmpty()) {
                holder.showAccomplices()
                val hexColor =
                    String.format(
                        "#%06X",
                        0xFFFFFF and holder.lessonContainer.cardBackgroundColor.defaultColor
                    )
                val participantAdapter = ParticipantAdapter(hexColor)
                holder.accomplices.adapter = participantAdapter
                holder.accomplices.layoutManager =
                    LinearLayoutManager(
                        holder.itemView.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                participantAdapter.items = item.participants
            }
            holder.showVerticalDivider()
            holder.setTimeInterval(item.timeStart, item.timeEnd)
        }
        if (typeListView == ListView.SMALL) {
            "${item.timeStart} - ${item.timeEnd}".also { holder.comment.text = it }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}