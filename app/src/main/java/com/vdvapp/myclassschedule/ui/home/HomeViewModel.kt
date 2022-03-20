package com.vdvapp.myclassschedule.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vdvapp.myclassschedule.domain.Command
import com.vdvapp.myclassschedule.domain.Homework
import com.vdvapp.myclassschedule.domain.User
import com.vdvapp.myclassschedule.ui.common.*

class HomeViewModel : ViewModel() {
    private val mListHomeFragmentStricture = MutableLiveData<List<PertainedHomeList>>().apply {
        value = listOf()
    }
    val listHomeFragmentStricture: LiveData<List<PertainedHomeList>> = mListHomeFragmentStricture

    fun fetchData() {
        mListHomeFragmentStricture.postValue(
            listOf(
                TimerForExams("Готов ли ты к экзаментам?", "Дата экзаменов"),
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
                ),
                HomeworkList(
                    "Homework", listOf(
                        Homework(
                            "Literature",
                            "2 days left",
                            "Read scenes 1.1-1.12 of The Master and Margarita.", listOf(
                                User("Первый", "Ученик", "user 1", "#FCD366", null),
                                User("Первый", "Ученик", "user 1", "#ff115566", null),
                                User("Второй", "Ученик", "user 2", "#ff994455", null)

                            )
                        ),
                        Homework(
                            "Physics",
                            "5 days left",
                            "Learn Newton's  law of universal gravitation", listOf(
                                User("Третий", "Ученик", "user 3", "#ff661188", null),
                                User("Четвертый", "Ученик", "user4", "#ff994455", null)
                            )
                        ),
                        Homework(
                            "Mathematics",
                            "7 days left",
                            "Read scenes 1.1-1.12 of The Master and Margarita.", listOf(
                                User("Пятый", "Ученик", "user 5", "#ff661188", null),
                                User("Шестой", "Ученик", "user 6", "#ff994455", null)
                            )
                        ),
                    )
                )
            )
        )
    }
}