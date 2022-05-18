package com.hakanoguz33.brainstoragev3.db

import android.annotation.SuppressLint
import android.widget.Toast
import com.hakanoguz33.brainstoragev3.db.brainStorageDb
import com.hakanoguz33.brainstoragev3.model.urunDB
import kotlin.coroutines.coroutineContext

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
    fun urunGetir(vt: brainStorageDb, urunId:Int): urunDB {
        lateinit var urun: urunDB

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
        if(sayi>=0)
            db?.execSQL("UPDATE urun SET envanter_sayisi = envanter_sayisi+$sayi WHERE id = $urunId")
    }
    fun envanterAzalt(vt:brainStorageDb,sayi:Int,urunId: Int){
        val db= vt.writableDatabase
        if(sayi>=0)
            db?.execSQL("UPDATE urun SET envanter_sayisi = envanter_sayisi-$sayi WHERE id = $urunId AND envater_sayisi>=$sayi")
    }
    fun envanterGuncelle(vt:brainStorageDb,sayi:Int,urunId: Int){
        val db= vt.writableDatabase
        if(sayi>=0)
            db?.execSQL("UPDATE urun SET envanter_sayisi = $sayi WHERE id = $urunId")
        else
            Toast.makeText()
    }
}