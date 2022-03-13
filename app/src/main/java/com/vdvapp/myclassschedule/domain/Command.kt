package com.vdvapp.myclassschedule.domain

import com.vdvapp.myclassschedule.ui.common.Participable

data class Command(
    val title: String,
    val systemEmblem: String,
    val customEmblem: String?,
    val listOfTeam: List<User>
) : Participable
