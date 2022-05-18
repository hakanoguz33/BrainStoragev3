package com.hakanoguz33.brainstoragev3.views

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.hakanoguz33.brainstoragev3.R
import com.hakanoguz33.brainstoragev3.db.brainStorageDb
import com.hakanoguz33.brainstoragev3.model.urunDB
import com.hakanoguz33.brainstoragev3.db.urunDBdao
import kotlinx.android.synthetic.main.fragment_product_page.*
import kotlinx.android.synthetic.main.fragment_product_page.view.*


class productPageFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarim = layoutInflater.inflate(R.layout.fragment_product_page,container,false)

        return tasarim
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var urunId:Int = 0
        var urun: urunDB = urunDB(1,"a",4,4,"",5)
        arguments?.let {
            urunId = productPageFragmentArgs.fromBundle(it).urunId
        }
        val vt = context?.let { brainStorageDb(it) }
        if (vt != null) {
            urun = urunDBdao().urunGetir(vt,urunId)
        }
        val uri = "@drawable/${urun.resim_yolu}" // where myresource (without the extension) is the file
        val imageResource = resources.getIdentifier(uri, null, context?.packageName)
        val imageview:ImageView = view.findViewById(R.id.productPageImageView)
        val res = resources.getDrawable(imageResource)
        imageview.setImageDrawable(res)
        view.productPageUrunAdiTextView.text = urun.isim
        view.productPageUrunSayiTextView.text = "Envanterdeki Kalan Adet:${urun.envanter_sayisi.toString()}"
        productPageToolbar.setTitle("Ürün Detay")
        view.ekleButton.setOnClickListener {
            val tasarim = layoutInflater.inflate(R.layout.alertview_tasarim,null)
            val ad = AlertDialog.Builder(context)
            val edittextAlert = tasarim.findViewById(R.id.editTextAlert) as EditText
            ad.setView(tasarim)
            ad.setMessage("Eklemek istediğiniz miktarı giriniz")
            ad.setTitle("Envantere Ekle")
            ad.setIcon(R.mipmap.brainstorage_launcher_foreground)
            ad.setPositiveButton("Ekle"){ dialogInterface, i ->
                val editableToString = edittextAlert.text.toString()
                if (!editableToString.contains(','))
                    vt?.let { it1 -> urunDBdao().envanterArttır(it1,editableToString.toInt(),urun.id) }
                else
                    Toast.makeText(view.context,"Hata! GEÇERLİ BİR SAYI GİRİNİZ",Toast.LENGTH_SHORT).show()
                onViewCreated(view,savedInstanceState)
            }
            ad.setNegativeButton("Iptal"){ dialogInterface, i->
                //do nothing
            }
            ad.create().show()
        }
        view.cikarButton.setOnClickListener {
            val tasarim = layoutInflater.inflate(R.layout.alertview_tasarim,null)
            val ad = AlertDialog.Builder(context)
            val edittextAlert = tasarim.findViewById(R.id.editTextAlert) as EditText
            ad.setView(tasarim)
            ad.setMessage("Çıkarmak istediğiniz miktarı giriniz")
            ad.setTitle("Envanterden Çıkar")
            ad.setIcon(R.mipmap.brainstorage_launcher_foreground)

            ad.setPositiveButton("Çıkar"){ dialogInterface, i ->
                val editableToString = edittextAlert.text.toString()
                if(!editableToString.contains(','))
                    vt?.let { it1 -> urunDBdao().envanterAzalt(it1,editableToString.toInt(),urun.id) }
                else
                    Toast.makeText(it.context,"Hata! GEÇERLİ BİR SAYI GİRİNİZ",Toast.LENGTH_SHORT).show()
                onViewCreated(view,savedInstanceState)
            }

            ad.setNegativeButton("Iptal"){ dialogInterface, i->
                //do nothing
            }

            ad.create().show()

        }
        view.miktarGuncelleButton.setOnClickListener {
            val tasarim = layoutInflater.inflate(R.layout.alertview_tasarim,null)
            val ad = AlertDialog.Builder(context)
            val edittextAlert = tasarim.findViewById(R.id.editTextAlert) as EditText
            ad.setView(tasarim)
            ad.setMessage("Güncelleme için Miktar Girin")
            ad.setTitle("Envanter Güncelle")
            ad.setIcon(R.mipmap.brainstorage_launcher_foreground)

            ad.setPositiveButton("Güncelle"){ dialogInterface, i ->
                val editableToString = edittextAlert.text.toString()
                if(!editableToString.contains(','))
                    vt?.let { it1 -> urunDBdao().envanterGuncelle(it1,editableToString.toInt(),urun.id) }
                else
                    Toast.makeText(it.context,"Hata! GEÇERLİ BİR SAYI GİRİNİZ",Toast.LENGTH_SHORT).show()
                onViewCreated(view,savedInstanceState)
            }

            ad.setNegativeButton("Iptal"){ dialogInterface, i->
                //do nothing
            }

            ad.create().show()
        }
    }
}