package com.hakanoguz33.brainstoragev3.db

import android.annotation.SuppressLint
import com.hakanoguz33.brainstoragev3.db.brainStorageDb
import com.hakanoguz33.brainstoragev3.model.kategoriDB

class kategoriDBdao() {
    @SuppressLint("Range")
    fun kategoriListele(vt:brainStorageDb,satici_id:Int):List<kategoriDB>{
        val liste = ArrayList<kategoriDB>()
        val db = vt.writableDatabase
        val cursor = db.rawQuery("SELECT * FROM kategori",null)
        while(cursor.moveToNext())
        {
            val kategori = kategoriDB(cursor.getInt(cursor.getColumnIndex("kategori_id")),cursor.getString(cursor.getColumnIndex("kategori_isim")),cursor.getInt(cursor.getColumnIndex("satici_id")))
            if(kategori.satici_id == satici_id)
                liste.add(kategori)
        }
        return liste
    }
}