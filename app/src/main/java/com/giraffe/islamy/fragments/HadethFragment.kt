package com.giraffe.islamy.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.giraffe.islamy.Constants
import com.giraffe.islamy.R
import com.giraffe.islamy.SurahDetailsActivity
import com.giraffe.islamy.adapters.HadethTitleAdapter
import com.giraffe.islamy.models.HadethModel

class HadethFragment:Fragment(),HadethTitleAdapter.OnHadethClickListener {
    private lateinit var rvHadeth:RecyclerView
    private lateinit var adapter:HadethTitleAdapter
    private var hadehtList:List<HadethModel> = listOf()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvHadeth = view.findViewById(R.id.rv_hadeth)
        adapter = HadethTitleAdapter(hadehtList,this)
        rvHadeth.adapter = adapter
        readFromFile()

    }

    override fun onHadethClick(hadeth: HadethModel, position: Int) {
        val intent = Intent(requireActivity(), SurahDetailsActivity::class.java)
        intent.putExtra(Constants.HADETH_TITLE_KEY,hadeth.title)
        intent.putExtra(Constants.HADETH_CONTENT_KEY,hadeth.content.toTypedArray())
        startActivity(intent)
        //Toast.makeText(requireContext(),"$position -> ${hadeth.title}",Toast.LENGTH_LONG).show()
    }
    private fun readFromFile(){
        val hadethModelList = mutableListOf<HadethModel>()
        val fileContent = requireActivity().assets.open("ahadeth.txt").bufferedReader().use { it.readText() }
        val hadethList = fileContent.trim().split("#")
        for(hadeth in hadethList){
            val hadethLines = hadeth.trim().split("\n").toMutableList()
            val title = hadethLines[0]
            hadethLines.removeAt(0)
            hadethModelList.add(HadethModel(title,hadethLines))
        }
        adapter.updateData(hadethModelList)
    }
}


