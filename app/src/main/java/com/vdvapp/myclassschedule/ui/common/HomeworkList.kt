package com.vdvapp.myclassschedule.ui.common

import com.vdvapp.myclassschedule.domain.Homework

data class HomeworkList(
    val title: String,
    val list: List<Homework>
): PertainedHomeList
