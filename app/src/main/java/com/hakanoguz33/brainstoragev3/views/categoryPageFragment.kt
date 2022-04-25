package com.hakanoguz33.brainstoragev3.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hakanoguz33.brainstoragev3.R

class categoryPageFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarim = inflater.inflate(R.layout.fragment_category_page,container,false)
        return tasarim
    }
}