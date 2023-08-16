package com.giraffe.islamy.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.giraffe.islamy.R
import com.giraffe.islamy.models.HadethModel

class HadethTitleAdapter(private var list:List<HadethModel>,val onHadethClickListener:OnHadethClickListener):Adapter<HadethTitleAdapter.HadethTitleViewHolder>() {
    inner class HadethTitleViewHolder(view: View):ViewHolder(view){
        val tvTitle:TextView = view.findViewById(R.id.tv_hadeth_title)
    }
    interface OnHadethClickListener{
        fun onHadethClick(hadeth:HadethModel,position:Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethTitleViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val view = inflate.inflate(R.layout.hadeth_item,parent,false)
        return HadethTitleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: HadethTitleViewHolder, position: Int) {
        val hadeth = list[position]
        holder.tvTitle.text = hadeth.title
        holder.tvTitle.setOnClickListener {
            onHadethClickListener.onHadethClick(hadeth,position)
        }
    }

    fun updateData(list:List<HadethModel>){
        this.list = list
        notifyDataSetChanged()
    }
}