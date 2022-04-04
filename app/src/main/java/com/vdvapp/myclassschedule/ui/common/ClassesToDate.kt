package com.vdvapp.myclassschedule.ui.common

data class ClassesToDate(
    val title: String,
    val date: String, // временно
    val classes: List<Lesson>
) : PertainedHomeList
