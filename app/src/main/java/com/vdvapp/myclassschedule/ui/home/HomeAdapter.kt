package com.vdvapp.myclassschedule.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.ui.common.*

class HomeAdapter(val context: Context?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
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
                holder.title.text = "Classes"
                holder.description.text = "${item.classes.size} classes todauy"
                var classesAdapter = ClassesAdapter()
                holder.list.adapter = classesAdapter
                holder.list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                classesAdapter.items = item.classes
                classesAdapter.notifyDataSetChanged()
            }
            is HomeworkList -> {
                holder as HomeworkListViewHolder
                holder.title.text = "Homework"
                var homeworkAdapter = HomeworkAdapter()
                holder.list.adapter = homeworkAdapter
                holder.list.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                homeworkAdapter.items = item.list
                homeworkAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}