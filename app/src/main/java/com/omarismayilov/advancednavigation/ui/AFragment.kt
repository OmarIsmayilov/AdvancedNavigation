package com.omarismayilov.advancednavigation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.omarismayilov.advancednavigation.BaseFragment
import com.omarismayilov.advancednavigation.MainActivity
import com.omarismayilov.advancednavigation.R
import com.omarismayilov.advancednavigation.databinding.FragmentABinding

class AFragment : BaseFragment<FragmentABinding>(FragmentABinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).supportActionBar?.title = "Fragment A"


    }
}