package com.hakanoguz33.brainstoragev3.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hakanoguz33.brainstoragev3.R
import com.hakanoguz33.brainstoragev3.adapter.productCategoryAdapter
import com.hakanoguz33.brainstoragev3.db.brainStorageDb
import com.hakanoguz33.brainstoragev3.db.urunDB
import com.hakanoguz33.brainstoragev3.viewmodel.urunDBdao
import kotlinx.android.synthetic.main.fragment_product_category.*

class productCategoryFragment : Fragment() {
    private lateinit var urunList:List<urunDB>
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarim = layoutInflater.inflate(R.layout.fragment_product_category,container,false)
        return tasarim
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val db = brainStorageDb(view.context)
        var satici_id = 0
        var kategori_id =0
        arguments?.let {
            satici_id = productCategoryFragmentArgs.fromBundle(it).saticiId
            kategori_id = productCategoryFragmentArgs.fromBundle(it).kategoriId
        }
        urunList = urunDBdao().urunGistesiGetir(db,satici_id,kategori_id)
        val adapter=activity?.let { productCategoryAdapter(it.applicationContext,urunList) }
        productCategoryRV.layoutManager = LinearLayoutManager(context)
        productCategoryRV.adapter = adapter
    }
}