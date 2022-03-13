package com.vdvapp.myclassschedule.ui.common

/**
 * Тип представления: (сквозная нумерация всех представлений для RV)
 * @property UNKNOWN_TYPE              неизвестный тип (при правильной работе программы не должен быть реализован)
 * @property TIMER                     таймер обратного отсчета
 * @property LIST_CLASSES              Список занятий (этот жлемент представляет сосбой вложенный список)
 * @property LIST_HOMEWORKS            Список домашних заданий (этот жлемент представляет сосбой вложенный список)
 * @property SEPARATOR                 Разделитель для списка
 */
object BaseViewType {
    const val UNKNOWN_TYPE = 0
    const val TIMER = 1
    const val LIST_CLASSES = 2
    const val LIST_HOMEWORKS = 3
    const val SEPARATOR = 4
}