package com.hakanoguz33.brainstoragev3.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class brainStorageDb(context:Context) : SQLiteOpenHelper(context,"brainStorageDatabase.db",null,1)   {
    override fun onCreate(db: SQLiteDatabase?) {

        try {
            db?.execSQL("CREATE TABLE IF NOT EXISTS \"satici\" (\n" +
                    "\t\"satici_id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                    "\t\"satici_user_name\"\tTEXT,\n" +
                    "\t\"satici_password\"\tTEXT\n" +
                    ");")

            db?.execSQL("CREATE TABLE IF NOT EXISTS \"kategori\" (\n" +
                    "\t\"kategori_id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                    "\t\"kategori_isim\"\tTEXT,\n" +
                    "\tFOREIGN KEY(\"kategori_id\") REFERENCES \"urun\"(\"kategori_id\")\n" +
                    ");")
            db?.execSQL("CREATE TABLE IF NOT EXISTS \"urun\" (\n" +
                    "\t\"id\"\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                    "\t\"isim\"\tTEXT,\n" +
                    "\t\"satici_id\"\tINTEGER,\n" +
                    "\t\"envanter_sayisi\"\tINTEGER,\n" +
                    "\t\"resim_yolu\"\tTEXT,\n" +
                    "\t\"kategori_id\"\tINTEGER\n" +
                    ");")

        }catch (e:Exception){
            Log.e("sql patladı",e.stackTrace.toString())
        }
    }
    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS satici")
        db?.execSQL("DROP TABLE IF EXISTS kategori")
        db?.execSQL("DROP TABLE IF EXISTS urun")
        onCreate(db)
    }
}