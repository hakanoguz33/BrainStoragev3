package com.hakanoguz33.brainstoragev3.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_main.*
import com.hakanoguz33.brainstoragev3.R
import kotlinx.android.synthetic.main.fragment_home_page.*


class homePageFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarim = layoutInflater.inflate(R.layout.fragment_home_page,container,false)



        return tasarim
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        girisButton.setOnClickListener {
            Navigation.findNavController(girisButton).navigate(R.id.action_homePageFragment_to_categoryPageFragment)

        }
        //Navigation.findNavController(girisButton).navigate(R.id.action_homePageFragment_to_categoryPageFragment)
    }
}