package com.vdvapp.myclassschedule.ui.userinfo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vdvapp.myclassschedule.R

class UserInfoFragment : Fragment() {

    companion object {
        fun newInstance() = UserInfoFragment()
    }

    private lateinit var viewModel: UserInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_info_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserInfoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}