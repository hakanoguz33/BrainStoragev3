package com.hakanoguz33.brainstoragev3.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.hakanoguz33.brainstoragev3.R
import com.hakanoguz33.brainstoragev3.model.urunDB
import com.hakanoguz33.brainstoragev3.views.productCategoryFragmentDirections

class productCategoryAdapter(mContext: Context,private val disaridanListe:List<urunDB>):RecyclerView.Adapter<productCategoryAdapter.tasarimTutucu>() {
    inner class tasarimTutucu(view: View):RecyclerView.ViewHolder(view){
        val cardviewim:CardView
        val kategoriName:TextView
        init {
            cardviewim = view.findViewById(R.id.card_viewim)
            kategoriName = view.findViewById(R.id.listelenecekTextView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): tasarimTutucu {
        val tasarim = LayoutInflater.from(parent.context).inflate(R.layout.satir_card_view,parent,false)
        return tasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: tasarimTutucu, position: Int) {

            val urunObject: urunDB = disaridanListe.get(position)
            holder.kategoriName.text = urunObject.isim
            holder.cardviewim.setOnClickListener {
                val action = productCategoryFragmentDirections.actionProductCategoryFragmentToProductPageFragment(urunObject.id)
                Navigation.findNavController(holder.cardviewim).navigate(action)}
    }

    override fun getItemCount(): Int {
        return disaridanListe.size
    }
}