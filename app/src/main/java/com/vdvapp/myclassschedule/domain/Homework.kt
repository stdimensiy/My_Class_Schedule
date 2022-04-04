package com.vdvapp.myclassschedule.domain

import com.vdvapp.myclassschedule.ui.common.Lesson
import java.util.*

data class Homework(
    val lesson: String, // временно
    val deadLine: String, // временно
    val task: String,
    val accomplices: List<User>
)
