package com.hakanoguz33.brainstoragev3.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hakanoguz33.brainstoragev3.R
import com.hakanoguz33.brainstoragev3.db.DatabaseCopyHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        try {
            veriTabaniKopyala()

        }catch (e:Exception){
            e.printStackTrace()
        }
    }
    fun veriTabaniKopyala(){
        val db = DatabaseCopyHelper(this)

        try {

            db.createDataBase()
        }catch (e:Exception)
        {
            e.printStackTrace()
        }
        try {
            db.openDataBase()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}