package com.hakanoguz33.brainstoragev3.viewmodel

import android.annotation.SuppressLint
import com.hakanoguz33.brainstoragev3.db.brainStorageDb
import com.hakanoguz33.brainstoragev3.db.saticiDB

class saticiDBdao() {
    @SuppressLint("Range")
    fun saticiBul(vt:brainStorageDb):List<saticiDB>{
        val liste = ArrayList<saticiDB>()

        val db = vt.writableDatabase

        val cursor= db.rawQuery("SELECT * FROM satici",null)
        while (cursor.moveToNext())
        {
            val satici = saticiDB(cursor.getInt(cursor.getColumnIndex("satici_id")),cursor.getString(cursor.getColumnIndex("satici_user_name")),cursor.getString(cursor.getColumnIndex("satici_password")))
            liste.add(satici)
        }
        return liste
    }
}