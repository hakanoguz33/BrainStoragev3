package com.hakanoguz33.brainstoragev3.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hakanoguz33.brainstoragev3.R
import com.hakanoguz33.brainstoragev3.adapter.categoryRV
import com.hakanoguz33.brainstoragev3.model.urun
import kotlinx.android.synthetic.main.fragment_category_page.*

class categoryPageFragment : Fragment() {
    private lateinit var urunList:ArrayList<urun>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarim = inflater.inflate(R.layout.fragment_category_page,container,false)
        return tasarim
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryPageRecyclerView.layoutManager = LinearLayoutManager(context)
        urunList = ArrayList<urun>()
        val a1 = urun("a",5)
        val a2 =urun("b",6)
        urunList.add(a1)
        urunList.add(a2)
        val adapter = activity?.let { categoryRV(it.applicationContext,urunList) }
        categoryPageRecyclerView.adapter = adapter
    }
}