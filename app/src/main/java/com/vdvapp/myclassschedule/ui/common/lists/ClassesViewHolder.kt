package com.vdvapp.myclassschedule.ui.common.lists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginTop
import androidx.recyclerview.widget.RecyclerView
import com.vdvapp.myclassschedule.R
import com.vdvapp.myclassschedule.databinding.ItemClassesSimpleTypeBinding

class ClassesViewHolder(
    li: LayoutInflater,
    parent: ViewGroup,
    binding: ItemClassesSimpleTypeBinding = ItemClassesSimpleTypeBinding.inflate(li, parent, false)
) : RecyclerView.ViewHolder(binding.root) {
    var title = binding.tvName
    var comment = binding.tvComment
    private val descriptionIcon = binding.ivDescriptionIcon
    private val divider = binding.divider
    private val headerPoint = binding.ivTimePoint
    private val headerTitle = binding.tvTimeInterval
    private val timeInterval = binding.tvTimeInterval
    val lLink = binding.llLink
    val lessonContainer = binding.cvLesson
    private val description = binding.tvDescription
    val accomplices = binding.rvAccomplices


    /**
     * Устанавливает картинку иконки занятия
     * в качестве параметра [res] ринимает Int ресурса приложения
     * т.е. работает корректно с присутствующими в ресурсах изображениями
     * @return нет возвращаемых значений
     */
    fun setDescriptionIcon(res: Int) {
        descriptionIcon.setImageResource(res)
    }

    /**
     * Устанавливает текстовое значение временного интервала занятия
     * в качестве параметра [start] и [stop] ринимает строковые значения времени начала
     * и окончания занятия переданные из репозитория
     * @return нет возвращаемых значений
     */
    fun setTimeInterval(start: String, stop: String) {
        "$start - $stop".also { timeInterval.text = it }
    }

    /**
     * Скрывает иконку занятия
     * применяется при необходимости, необходимо обращать внимание на поведение разметки после
     * сокрытия картинки, ибо относительно данного элемента выполнено большинство привязок
     * основного контента элемента списка
     * @return нет возвращаемых значений
     */
    fun hideDescriptionIcon() {
        descriptionIcon.visibility = View.GONE
    }

    /**
     * Показывает иконку занятия (не устанавливает) и не меняет содержимого элемента ImageView
     * если ничего не передано в качестве параметра [res] который ринимает Int ресурса приложения
     * @return нет возвращаемых значений
     */
    fun showDescriptionIcon(res: Int? = null) {
        descriptionIcon.visibility = View.VISIBLE
        res?.let { descriptionIcon.setImageResource(it) }
    }

    /**
     * Скрывает фрагмент разметки в виде вертикальной черты разделителя
     * @return нет возвращаемых значений
     */
    fun hideVerticalDivider() {
        divider.visibility = View.GONE
    }

    /**
     * Показывает фрагмент разметки в виде вертикальной черты разделителя
     * (визуальное оформление элемента применяется лучше при вертикальном расположении элементов
     * списка)
     * @return нет возвращаемых значений
     */
    fun showVerticalDivider() {
        divider.visibility = View.VISIBLE
    }

    /**
     * Скрывает фрагмент разметки в виде стилизованной точки разделяителя
     * @return нет возвращаемых значений
     */
    fun hideTimePoint() {
        headerPoint.visibility = View.GONE
    }

    /**
     * Включает (показывает) фрагмент разметки в виде стилизованной точки разделяителя
     * @return нет возвращаемых значений
     */
    fun showTimePoint() {
        headerPoint.visibility = View.VISIBLE
    }

    /**
     * меняет представление временной точки (разделителя) ч большой на маленькую
     * по определению элемент содержит большую (стартовую) временноую точку
     * (как оформление вертикального списка)
     * @return нет возвращаемых значений
     */
    fun setSmallTimePoint() {
        headerPoint.setImageResource(R.drawable.time_point)
    }

    /**
     * Скрывает фрагмент разметки в виде заголовка карточки
     * @return нет возвращаемых значений
     */
    fun hideItemHeader() {
        headerTitle.visibility = View.GONE
    }

    /**
     * Включает (показывает) фрагмент разметки в виде заголовка карточки
     * @return нет возвращаемых значений
     */
    fun showItemHeader() {
        headerTitle.visibility = View.VISIBLE
        val params = lessonContainer.layoutParams as ViewGroup.MarginLayoutParams
        params.setMargins(0,50,0,64)
        lessonContainer.layoutParams = params
    }

    /**
     * Скрывает модуль (ViewGroup) отвечающий за возможность
     * перехада по ссылке (открыть стороннее приложение)
     * @return нет возвращаемых значений
     */
    fun hideLink() {
        lLink.visibility = View.GONE
    }

    /**
     * Делает видимым модуль (ViewGroup) отвечающий за возможность
     * перехада по ссылке (открыть стороннее приложение)
     * @return нет возвращаемых значений
     */
    fun showLink() {
        lLink.visibility = View.VISIBLE
    }

    /**
     * Делает видимым комментарий к занятию
     * и передает [text] в соответствующее поле для отображения
     * @return нет возвращаемых значений
     */
    fun showDescription(text: String) {
        description.visibility = View.VISIBLE
        description.text = text
    }

    /**
     * Скрывает комментарий к занятию изменяя видимость соответствующего элемента
     * значения поля text скрываемого элемента не меняет
     * @return нет возвращаемых значений
     */
    fun hideDescription() {
        description.visibility = View.GONE
    }

    /**
     * Отображает (делает видимым и активирует) список связанных пользователей и групп
     * назначенных данному занятию
     * @return нет возвращаемых значений
     */
    fun showAccomplices() {
        accomplices.visibility = View.VISIBLE
    }

    /**
     * Скрывает список связанных пользователей и групп
     * назначенных данному занятию
     * @return нет возвращаемых значений
     */
    fun hideAccomplices() {
        accomplices.visibility = View.GONE
    }

    /**
     * меняет представление элемента на специальное (в данном случае сигнализирует о том,
     * что это факультатив) и в данном случае меняется цывет фона
     * @return нет возвращаемых значений
     */
    fun makeItSpecial() {
        lessonContainer.setBackgroundResource(R.drawable.background_for_card_gradient)
    }
}