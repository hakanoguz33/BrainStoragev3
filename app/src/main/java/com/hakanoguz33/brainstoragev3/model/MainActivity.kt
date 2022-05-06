package com.hakanoguz33.brainstoragev3.model

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hakanoguz33.brainstoragev3.R
import com.hakanoguz33.brainstoragev3.adapter.categoryRV
import kotlinx.android.synthetic.main.fragment_category_page.*

class MainActivity : AppCompatActivity() {
    private lateinit var urunList:ArrayList<urun>
    private lateinit var adapter:categoryRV
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}