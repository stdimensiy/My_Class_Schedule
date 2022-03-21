package com.vdvapp.myclassschedule.ui.common

data class Lesson(
    val timeStart: String,
    val timeEnd: String,
    val badge: String,
    val title: String,
    val Teacher: String,
    val isOpenInSkype: Boolean,
    val isAdditionalLesson: Boolean,
    val annotation: String,
    val participants: List<Participable>
)
