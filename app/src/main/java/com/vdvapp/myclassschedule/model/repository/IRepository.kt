package com.vdvapp.myclassschedule.model.repository

import com.vdvapp.myclassschedule.domain.CallBack
import com.vdvapp.myclassschedule.ui.common.ClassesToDate
import com.vdvapp.myclassschedule.domain.Homework
import com.vdvapp.myclassschedule.ui.common.Lesson
import com.vdvapp.myclassschedule.ui.common.Participable

interface IRepository {
    fun getListHomework(callBack: CallBack<List<Homework>>)
    fun getClassesToDate(callBack: CallBack<ClassesToDate>)
    fun getListOfParticipants(callBack: CallBack<Participable>)
    fun getFavorites(callBack: CallBack<List<Lesson>>)
}