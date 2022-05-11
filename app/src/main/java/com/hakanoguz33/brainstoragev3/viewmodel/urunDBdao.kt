package com.hakanoguz33.brainstoragev3.viewmodel

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.hakanoguz33.brainstoragev3.db.brainStorageDb
import com.hakanoguz33.brainstoragev3.db.urunDB
import kotlin.Exception

class urunDBdao() {
    @SuppressLint("Range")
    fun urunGistesiGetir(vt: brainStorageDb, satici_id:Int, kategori_id:Int):List<urunDB>{

        val urunList = ArrayList<urunDB>()

        val db = vt.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM urun",null)
        while (cursor.moveToNext())
        {
            val urun = urunDB(cursor.getInt(cursor.getColumnIndex("id")),cursor.getString(cursor.getColumnIndex("isim")),
            cursor.getInt(cursor.getColumnIndex("satici_id")),cursor.getInt(cursor.getColumnIndex("envanter_sayisi")),
            cursor.getString(cursor.getColumnIndex("resim_yolu")),cursor.getInt(cursor.getColumnIndex("kategori_id")))
            if (urun.satici_id == satici_id && urun.kategori_id == kategori_id)
                urunList.add(urun)
        }
        return urunList
    }
    @SuppressLint("Range")
    fun urunGetir(vt: brainStorageDb, urunId:Int):urunDB {
        lateinit var urun:urunDB

        val db= vt.writableDatabase

        val cursor = db.rawQuery("SELECT * FROM urun",null)
        while (cursor.moveToNext()) {
            urun = urunDB(
                cursor.getInt(cursor.getColumnIndex("id")),
                cursor.getString(cursor.getColumnIndex("isim")),
                cursor.getInt(cursor.getColumnIndex("satici_id")),
                cursor.getInt(cursor.getColumnIndex("envanter_sayisi")),
                cursor.getString(cursor.getColumnIndex("resim_yolu")),
                cursor.getInt(cursor.getColumnIndex("kategori_id")))
            if (urun.id == urunId)
                break
        }
        return urun
    }

    fun envanterArttır(vt:brainStorageDb,sayi:Int,urunId: Int){
        val db= vt.writableDatabase
        db?.execSQL("UPDATE urun SET envanter_sayisi = envanter_sayisi+$sayi WHERE id = $urunId")
    }
    fun envanterAzalt(vt:brainStorageDb,sayi:Int,urunId: Int){
        val db= vt.writableDatabase
        db?.execSQL("UPDATE urun SET envanter_sayisi = envanter_sayisi-$sayi WHERE id = $urunId")
    }
}