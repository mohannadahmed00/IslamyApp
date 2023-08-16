package com.giraffe.islamy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.giraffe.islamy.R

class SurahDetailsAdapter(private var list:List<String>):Adapter<SurahDetailsAdapter.SurahDetailsViewHolder>(){
    inner class SurahDetailsViewHolder(view: View):ViewHolder(view){
        val tvVerse:TextView = view.findViewById(R.id.tv_verse)

    }

    fun updateData(list:List<String>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahDetailsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view= inflater.inflate(R.layout.verse_item,parent,false)
        return SurahDetailsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SurahDetailsViewHolder, position: Int) {
        val verse = list[position]
        holder.tvVerse.text = verse
    }
}