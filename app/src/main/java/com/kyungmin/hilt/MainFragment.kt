package com.kyungmin.hilt

import com.kyungmin.hilt.base.UtilityBase
import com.kyungmin.hilt.databinding.FragmentMainBinding

class MainFragment : UtilityBase.BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    override fun FragmentMainBinding.onCreateView() {

    }

    override fun FragmentMainBinding.onViewCreated() {
        binding.tvFragment.text = "Fragment"
    }
}