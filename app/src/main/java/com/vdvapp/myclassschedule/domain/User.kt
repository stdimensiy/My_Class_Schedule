package com.vdvapp.myclassschedule.domain

import com.vdvapp.myclassschedule.ui.common.Participable

data class User(
    val name: String,
    val role: String,
    val systemAvatar: String,
    val customAvatar: String?
) : Participable
