package com.hakanoguz33.brainstoragev3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.hakanoguz33.brainstoragev3.R
import com.hakanoguz33.brainstoragev3.db.kategoriDB

class productCategoryAdapter(mContext: Context,private val disaridanListe:List<kategoriDB>):RecyclerView.Adapter<productCategoryAdapter.tasarimTutucu>() {
    inner class tasarimTutucu(view: View):RecyclerView.ViewHolder(view){
        val cardviewim:CardView
        val kategoriName:TextView
        init {
            cardviewim = view.findViewById(R.id.card_viewim)
            kategoriName = view.findViewById(R.id.urunadTextView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tasarimTutucu {
        val tasarim = LayoutInflater.from(parent.context).inflate(R.layout.satir_card_view,parent,false)
        return tasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: tasarimTutucu, position: Int) {
        var kategoriObject = kategoriDB(0,"a")
        kategoriObject = disaridanListe.get(position)
        holder.kategoriName.text = kategoriObject.kategori_isim
    }

    override fun getItemCount(): Int {
        return disaridanListe.size
    }
}