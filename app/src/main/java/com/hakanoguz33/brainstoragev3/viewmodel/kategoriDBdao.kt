package com.hakanoguz33.brainstoragev3.viewmodel

import android.annotation.SuppressLint
import com.hakanoguz33.brainstoragev3.db.brainStorageDb
import com.hakanoguz33.brainstoragev3.db.kategoriDB

class kategoriDBdao() {
    @SuppressLint("Range")
    fun kategoriListele(vt:brainStorageDb):List<kategoriDB>{
        val liste = ArrayList<kategoriDB>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM kategori",null)
        while(cursor.moveToNext())
        {
            val kategori = kategoriDB(cursor.getInt(cursor.getColumnIndex("kategori_id")),cursor.getString(cursor.getColumnIndex("kategori_isim")))
            liste.add(kategori)
        }
        return liste
    }
}