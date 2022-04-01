package com.vdvapp.myclassschedule.ui.classes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vdvapp.myclassschedule.databinding.FragmentClassesBinding
import com.vdvapp.myclassschedule.ui.common.BaseFragment

class ClassesFragment : BaseFragment<FragmentClassesBinding>() {
    private lateinit var adapter: ClassesFragmentAdapter
    private lateinit var viewModel: ClassesViewModel //временно там заглушка

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[ClassesViewModel::class.java]

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val classesList = binding.rvClasses
        adapter = ClassesFragmentAdapter()
        classesList.adapter = adapter
        classesList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewModel.fetchData()
        viewModel.listClassesToDate.observe(viewLifecycleOwner) {
            adapter.items = it.classes
            adapter.notifyDataSetChanged()
        }
    }

}