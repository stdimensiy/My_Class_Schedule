package com.vdvapp.myclassschedule.ui.classes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vdvapp.myclassschedule.domain.Command
import com.vdvapp.myclassschedule.domain.User
import com.vdvapp.myclassschedule.ui.common.*

class ClassesViewModel : ViewModel() {

    private val mListClassesToDate = MutableLiveData<ClassesToDate>().apply {
        value = ClassesToDate("EmptyClasses", "123", listOf())
    }
    val listClassesToDate: LiveData<ClassesToDate> = mListClassesToDate

    fun fetchData() {
        mListClassesToDate.postValue(
            ClassesToDate(
                "Classes",
                "123",
                listOf(
                    Lesson(
                        "8:00",
                        "8:45",
                        "badgeHistory",
                        "History",
                        "Mrs Thomas",
                        isOpenInSkype = true,
                        isAdditionalLesson = false,
                        annotation = "",
                        participants = listOf()
                    ),
                    Lesson(
                        "9:00",
                        "9:45",
                        "badgeLiterature",
                        "Literature",
                        "Mrs Barros",
                        isOpenInSkype = false,
                        isAdditionalLesson = false,
                        annotation = "",
                        participants = listOf()
                    ),
                    Lesson(
                        "10:00",
                        "11:35",
                        "badgePhysical Education",
                        "Physical Education",
                        "Mrs Barros",
                        isOpenInSkype = false,
                        isAdditionalLesson = true,
                        annotation = "Intensive preparation for The Junior World Championship in Los Angeles",
                        participants = listOf(
                            Command("Первая", "Эмблемка 1", null, listOf<User>()),
                            Command("Вторая", "Эмблемка 2", null, listOf<User>()),
                            Command("Третья", "Эмблемка 3", null, listOf<User>()),
                        )
                    ),
                )
            )
        )
    }
}