package com.hakanoguz33.brainstoragev3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hakanoguz33.brainstoragev3.R
import com.hakanoguz33.brainstoragev3.model.urun

class categoryRV(private val mContext: Context, private val disaridanListe:List<urun>)
    : RecyclerView.Adapter<categoryRV.cardViewTasarimTutucu>() {
    inner class cardViewTasarimTutucu(view: View):RecyclerView.ViewHolder(view){
        var satirCardView:CardView
        var urunName:TextView
        init {
            satirCardView = view.findViewById(R.id.card_viewim)
            urunName = view.findViewById(R.id.urunadTextView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardViewTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.satir_card_view,parent,false)
        return cardViewTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: cardViewTasarimTutucu, position: Int) {
        val temp:urun = disaridanListe.get(position)
        holder.urunName.text = temp.isim

        holder.satirCardView.setOnClickListener{
            Navigation.findNavController(holder.satirCardView).navigate(R.id.action_categoryPageFragment_to_productCategoryFragment)
        }
    }

    override fun getItemCount(): Int {
        return disaridanListe.size
    }
}