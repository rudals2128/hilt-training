package com.kyungmin.hilt.ui.main.view

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.kyungmin.hilt.R
import com.kyungmin.hilt.base.UtilityBase
import com.kyungmin.hilt.data.model.Items
import com.kyungmin.hilt.databinding.ActivityMainBinding
import com.kyungmin.hilt.ui.main.adapter.MainAdapter
import com.kyungmin.hilt.ui.main.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity :
    UtilityBase.BaseAppCompatActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val mainViewModel: MainViewModel by viewModels()
    private lateinit var adapter: MainAdapter

    override fun ActivityMainBinding.onCreate() {
        setupUI()
        setupObserver()
    }

    private fun setupUI() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.recyclerView.context,
                (binding.recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        binding.recyclerView.adapter = adapter
    }

    private fun setupObserver() {
        mainViewModel.photos.observe(this, Observer {
            renderList(it)
        })
    }

    private fun renderList(photos: ArrayList<Items>) {
        adapter.addData(photos)
        adapter.notifyDataSetChanged()
    }
}
