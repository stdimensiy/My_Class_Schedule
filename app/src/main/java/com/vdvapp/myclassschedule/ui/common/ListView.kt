package com.vdvapp.myclassschedule.ui.common

/**
 * Перечисление типов представления списков
 * [SMALL] маленокое краткое, содержит только 3 поля (картинку, титул и комментарий),
 * интерактивное но не позволяет растягивать разметку по высоте
 * [FULL] содержит полный набор полей, позволяет растягивать элементы разметки по высоте,
 * содержит разделители и заголовки, интерактивная.
 */
enum class ListView {
    SMALL,
    FULL
}