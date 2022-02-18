package com.vdvapp.myclassschedule.ui.common

import androidx.lifecycle.ViewModel
import com.vdvapp.myclassschedule.model.repository.Repository

class BaseViewModel : ViewModel() {
    protected val TAG = "${BaseConstants.MY_TAG} / ${this.javaClass.simpleName}"
    protected val repository = Repository()
}