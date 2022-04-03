package com.vdvapp.myclassschedule.ui.classes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vdvapp.myclassschedule.databinding.FragmentClassesBinding
import com.vdvapp.myclassschedule.ui.common.BaseFragment
import com.vdvapp.myclassschedule.ui.common.ListView
import com.vdvapp.myclassschedule.ui.common.lists.ClassesAdapter

class ClassesFragment : BaseFragment<FragmentClassesBinding>() {
    private lateinit var adapter: ClassesAdapter
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
        adapter = ClassesAdapter(ListView.FULL)
        classesList.adapter = adapter
        classesList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewModel.fetchData()
        viewModel.listClassesToDate.observe(viewLifecycleOwner) {
            setHeaderComment(it.date)
            adapter.items = it.classes
            adapter.notifyDataSetChanged()
        }
    }

    fun setHeaderComment(comment: String){
        binding.subscriptComment.text = comment
    }

}