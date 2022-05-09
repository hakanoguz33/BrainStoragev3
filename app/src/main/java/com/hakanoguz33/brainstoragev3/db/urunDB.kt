package com.hakanoguz33.brainstoragev3.db

data class urunDB(var id:Int,
                  var isim:String,
                  var satici_id:Int,
                  var envanter_sayisi:Int,
                  var resim_yolu:String,
                  var kategori_id:Int)
{
}