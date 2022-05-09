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
import com.hakanoguz33.brainstoragev3.db.brainStorageDb
import com.hakanoguz33.brainstoragev3.db.kategoriDB
import com.hakanoguz33.brainstoragev3.viewmodel.kategoriDBdao
import kotlinx.android.synthetic.main.fragment_category_page.*

class categoryPageFragment : Fragment() {
    private lateinit var kategoriList:List<kategoriDB>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarim = inflater.inflate(R.layout.fragment_category_page,container,false)
        return tasarim
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = brainStorageDb(view.context)
        kategoriList = kategoriDBdao().kategoriListele(db)
        categoryPageRecyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = activity?.let { categoryRV(it.applicationContext,kategoriList) }
        categoryPageRecyclerView.adapter = adapter
    }
}