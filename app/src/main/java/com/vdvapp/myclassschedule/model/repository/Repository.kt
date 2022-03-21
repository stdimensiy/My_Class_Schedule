package com.vdvapp.myclassschedule.model.repository

import com.vdvapp.myclassschedule.domain.CallBack
import com.vdvapp.myclassschedule.ui.common.ClassesToDate
import com.vdvapp.myclassschedule.domain.Homework
import com.vdvapp.myclassschedule.ui.common.Lesson
import com.vdvapp.myclassschedule.ui.common.Participable

class Repository : IRepository {
    override fun getListHomework(callBack: CallBack<List<Homework>>) {
        TODO("Not yet implemented")
    }

    override fun getClassesToDate(callBack: CallBack<ClassesToDate>) {
        TODO("Not yet implemented")
    }

    override fun getListOfParticipants(callBack: CallBack<Participable>) {
        TODO("Not yet implemented")
    }

    override fun getFavorites(callBack: CallBack<List<Lesson>>) {
        TODO("Not yet implemented")
    }
}