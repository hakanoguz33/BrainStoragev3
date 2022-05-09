package com.hakanoguz33.brainstoragev3.viewmodel

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import java.io.FileOutputStream
import java.io.IOException
import java.lang.Error

class databaseCopyHelper(private val mContext : Context):SQLiteOpenHelper(mContext,DB_NAME,null,1) {

    internal var DB_PATH:String? = null

    private var myDataBase: SQLiteDatabase? = null

    init {
        DB_PATH = "/data/data" + mContext.packageName + "/" + "databases/"
    }

    @Throws(IOException::class)
    fun createDatabase(){
        val dbExist = checkDataBase()

        if (dbExist)
        {

        }
        else{
            this.readableDatabase

            try {
               copyDataBase()
            }catch (e:IOException){
                throw Error("error copying database")
            }
        }
    }

    private fun checkDataBase() :Boolean{
        var checkDB:SQLiteDatabase? = null

        try {
            val myPath = DB_PATH + DB_NAME
        }catch (e:SQLiteException){

        }

        checkDB?.close()
        return if(checkDB != null) true else false
    }

    @Throws(IOException::class)
    private fun copyDataBase(){
        val myInput = mContext.assets.open(DB_NAME)

        val outFileName = DB_PATH + DB_NAME

        val myOutPut = FileOutputStream(outFileName)

        val buffer = ByteArray(1024)
        var length:Int = 0
        while ({length = myInput.read(buffer);length}() > 0)
        {
            myOutPut.write(buffer,0,length)
        }

        myOutPut.flush()
        myOutPut.close()
        myInput.close()
    }

    @Throws(IOException::class)
    fun openDataBase(){

        val myPath = DB_PATH + DB_NAME
        myDataBase = SQLiteDatabase.openDatabase(myPath,null,SQLiteDatabase.OPEN_READONLY)
    }

    @Synchronized
    override fun close() {
        if(myDataBase != null)
            myDataBase!!.close()

        super.close()
    }

    override fun onCreate(p0: SQLiteDatabase?) {

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
        db?.disableWriteAheadLogging()

    }

    companion object{
        private val  DB_NAME = "brainStorageDatabase.sqlite"
    }
}