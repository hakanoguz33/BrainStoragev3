package com.hakanoguz33.brainstoragev3.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import com.hakanoguz33.brainstoragev3.db.brainStorageDb
import com.hakanoguz33.brainstoragev3.db.urunDB

class urunDBdao() {
    @SuppressLint("Range")
    fun urunleriGetir(vt: brainStorageDb,saticiId:Int):List<urunDB>{

        val urunList = ArrayList<urunDB>()

        val db = vt.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM urun",null)
        while (cursor.moveToNext())
        {
            val urun = urunDB(cursor.getInt(cursor.getColumnIndex("id")),cursor.getString(cursor.getColumnIndex("isim")),
            cursor.getInt(cursor.getColumnIndex("satici_id")),cursor.getInt(cursor.getColumnIndex("envanter_sayisi")),
            cursor.getString(cursor.getColumnIndex("resim_yolu")),cursor.getInt(cursor.getColumnIndex("kategori_id")))

            if (urun.satici_id == saticiId){
                urunList.add(urun)
            }
        }
        return urunList
    }
}