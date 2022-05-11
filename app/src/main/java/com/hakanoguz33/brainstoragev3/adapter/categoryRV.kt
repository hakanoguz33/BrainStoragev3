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
import com.hakanoguz33.brainstoragev3.model.kategoriDB
import com.hakanoguz33.brainstoragev3.views.categoryPageFragmentDirections

class categoryRV(private val mContext: Context, private val disaridanListe:List<kategoriDB>)
    : RecyclerView.Adapter<categoryRV.cardViewTasarimTutucu>() {
    inner class cardViewTasarimTutucu(view: View):RecyclerView.ViewHolder(view){
        var satirCardView:CardView
        var urunName:TextView
        init {
            satirCardView = view.findViewById(R.id.card_viewim)
            urunName = view.findViewById(R.id.listelenecekTextView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardViewTasarimTutucu {
        val tasarim = LayoutInflater.from(mContext).inflate(R.layout.satir_card_view,parent,false)
        return cardViewTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: cardViewTasarimTutucu, position: Int) {
        val temp: kategoriDB = disaridanListe.get(position)
        holder.urunName.text = temp.kategori_isim
        holder.satirCardView.setOnClickListener{
            val action = categoryPageFragmentDirections.actionCategoryPageFragmentToProductCategoryFragment(temp.satici_id,temp.kategori_id)
            Navigation.findNavController(holder.satirCardView).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return disaridanListe.size
    }
}