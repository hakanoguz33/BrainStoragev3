package com.hakanoguz33.brainstoragev3.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.hakanoguz33.brainstoragev3.R
import com.hakanoguz33.brainstoragev3.db.brainStorageDb
import com.hakanoguz33.brainstoragev3.db.urunDB
import com.hakanoguz33.brainstoragev3.viewmodel.urunDBdao
import kotlinx.android.synthetic.main.fragment_product_page.view.*


class productPageFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val tasarim = layoutInflater.inflate(R.layout.fragment_product_page,container,false)
        return tasarim
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var urunId:Int = 0
        var urun:urunDB = urunDB(1,"a",4,4,"",5)
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

        view.ekleButton.setOnClickListener {
            vt?.let { it1 -> urunDBdao().envanterArttır(it1,1,urun.id) }
            onViewCreated(view,savedInstanceState)
        }
        view.cikarButton.setOnClickListener {
            vt?.let { it1 -> urunDBdao().envanterAzalt(it1,1,urun.id) }
            onViewCreated(view,savedInstanceState)
        }
    }
}