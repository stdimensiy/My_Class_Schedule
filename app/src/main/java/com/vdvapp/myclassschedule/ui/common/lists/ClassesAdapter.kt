package com.vdvapp.myclassschedule.ui.common.lists

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.ui.common.BaseConstants
import com.vdvapp.myclassschedule.ui.common.Lesson
import com.vdvapp.myclassschedule.ui.common.ListView


class ClassesAdapter(private val typeListView: ListView) :
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
        if (item.isOpenInSkype) {
            holder.showLink()
            holder.lLink.setOnClickListener {
                skype(BaseConstants.BASE_SKYPE_NUMBER, it.context)
            }
        }
        if (item.isAdditionalLesson) holder.makeItSpecial()
        holder.showDescriptionIcon()
        // при полном отображении разметки: режим FULL
        if (typeListView == ListView.FULL) {
            holder.hideDescriptionIcon()
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

    private fun skype(
        address: String?,
        myContext: Context
    ) {
        try {
            if (!isSkypeClientInstalled(myContext)) {
                goToMarket(myContext)
                return
            }
            val pm = myContext.packageManager
            val myIntent = pm.getLaunchIntentForPackage("com.skype.raider")
            myIntent?.data = Uri.parse("skype:$address")
            myContext.startActivity(myIntent)
        } catch (e: ActivityNotFoundException) {
            Log.e("Моя проверка", "Skype failed!!!", e)
        }
    }

    private fun isSkypeClientInstalled(myContext: Context): Boolean {
        val myPackageMgr = myContext.packageManager
        try {
            myPackageMgr.getPackageInfo("com.skype.raider", PackageManager.GET_ACTIVITIES)
        } catch (e: PackageManager.NameNotFoundException) {
            Log.e(
                "Моя проверка",
                "ПРИЛОЖЕНИЕ НЕ НАЙДЕНО (Вероятно не установлено на устройстве)!!!",
                e
            )
            return false
        }
        return true
    }

    private fun goToMarket(myContext: Context) {
        val marketUri = Uri.parse("market://details?id=com.skype.raider")
        val myIntent = Intent(Intent.ACTION_VIEW, marketUri)
        myIntent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        myContext.startActivity(myIntent)
        return
    }
}