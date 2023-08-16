package com.giraffe.islamy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.giraffe.islamy.R
import com.giraffe.islamy.models.SurahModel

class SurahAdapter(private val list:List<SurahModel>, private val onClick: OnSurahClickListener) : RecyclerView.Adapter<SurahAdapter.SurahViewHolder>() {

    inner class SurahViewHolder(view:View): ViewHolder(view) {
        val clSura:ConstraintLayout = view.findViewById(R.id.cl_surah)
        val tvSuraName:TextView = view.findViewById(R.id.tv_surah_name)
        val tvSuraIndex:TextView = view.findViewById(R.id.tv_surah_index)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.surah_item,parent,false)
        return SurahViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SurahViewHolder, position: Int) {
        val surah = list[position]
        holder.tvSuraName.text = surah.name
        holder.tvSuraIndex.text = surah.index.toString()
        holder.clSura.setOnClickListener {
            onClick.onSurahClick(surah,position)
        }
    }
    interface OnSurahClickListener{
        fun onSurahClick(surah:SurahModel,position:Int)
    }
}