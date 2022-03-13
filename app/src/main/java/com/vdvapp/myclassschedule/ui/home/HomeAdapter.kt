package com.vdvapp.myclassschedule.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.ui.common.*

class HomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items: List<PertainedHomeList> = listOf()

    override fun getItemViewType(position: Int) = when (items[position]) {
        is TimerForExams -> BaseViewType.TIMER
        is ClassesToDate -> BaseViewType.LIST_CLASSES
        is HomeworkList -> BaseViewType.LIST_HOMEWORKS
        else -> BaseViewType.UNKNOWN_TYPE
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            BaseViewType.TIMER -> TimerViewHolder(layoutInflater, parent)
            BaseViewType.LIST_CLASSES -> ClassesListViewHolder(layoutInflater, parent)
            BaseViewType.LIST_HOMEWORKS -> HomeworkListViewHolder(layoutInflater, parent)
            else -> UnknownTypeViewHolder(layoutInflater, parent)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is TimerForExams -> {
                holder as TimerViewHolder
                holder.setTitle("Таймер присоединен")
                holder.setStartTime("123")
            }
            is ClassesToDate -> {
                holder as ClassesListViewHolder
                holder.title.text = "Лист занятий прикреплен"
            }
            is HomeworkList -> {
                holder as HomeworkListViewHolder
                holder.title.text = "Лист ДЗ прикреплен"
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}