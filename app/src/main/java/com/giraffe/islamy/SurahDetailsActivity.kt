package com.giraffe.islamy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.giraffe.islamy.adapters.SurahDetailsAdapter

class SurahDetailsActivity : AppCompatActivity() {

    private var surahIndex = 0
    private lateinit var ivBack:ImageView
    private lateinit var tvSurahName:TextView
    private lateinit var rvVerses:RecyclerView
    private lateinit var adapter:SurahDetailsAdapter

    private lateinit var title: String

    private var list:List<String> = listOf()

    //private lateinit var hadethTitle:String
    //private lateinit var hadethContent:List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_surah_details)
        ivBack = findViewById(R.id.iv_back)
        tvSurahName = findViewById(R.id.tv_surah_name)
        rvVerses = findViewById(R.id.rv_surah_details)
        adapter = SurahDetailsAdapter(list)
        rvVerses.adapter = adapter



        if(intent.getStringExtra(Constants.SURAH_NAME_KEY)!=null) {
            title = intent.getStringExtra(Constants.SURAH_NAME_KEY) ?: ""
            surahIndex = intent.getIntExtra(Constants.SURAH_INDEX_KEY, 0)
            list = readFromFile()
        }else{
            title = intent.getStringExtra(Constants.HADETH_TITLE_KEY) ?: ""
            list = intent.getStringArrayExtra(Constants.HADETH_CONTENT_KEY)?.toList()?: listOf()
        }
        adapter.updateData(list)

        tvSurahName.text = "$title"
        ivBack.setOnClickListener {
            onBackPressed()
        }






    }
    private fun readFromFile():List<String>{
        val fileContent = assets.open("$surahIndex.txt").bufferedReader().use { it.readText() }
        return  fileContent.trim().split("\n")
        //adapter.updateData(list)
    }
}