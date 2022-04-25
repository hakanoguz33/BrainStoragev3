package com.hakanoguz33.brainstoragev3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.hakanoguz33.brainstoragev3.R
import com.hakanoguz33.brainstoragev3.model.urun

class categoryRVadapter(private val mContext: Context,private val urunlerListesi:ArrayList<urun>):RecyclerView.Adapter<categoryRVadapter.cardViewTutucu>(){
    inner class cardViewTutucu(view:View):RecyclerView.ViewHolder(view){
        var cardViewTasarim:CardView
        var urunIsım:TextView

        init {
            cardViewTasarim = view.findViewById(R.id.categoryCardView)
            urunIsım = view.findViewById(R.id.categoryTextView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardViewTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.fragment_category_page,parent,false)
        return cardViewTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: cardViewTutucu, position: Int) {
        val urun = urunlerListesi[position]
        holder.urunIsım.text = urun.urunIsım
        holder.cardViewTasarim.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return urunlerListesi.size
    }

}