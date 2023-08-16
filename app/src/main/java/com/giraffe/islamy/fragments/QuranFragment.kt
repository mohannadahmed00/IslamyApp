package com.giraffe.islamy.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.giraffe.islamy.Constants
import com.giraffe.islamy.R
import com.giraffe.islamy.SurahDetailsActivity
import com.giraffe.islamy.adapters.SurahAdapter
import com.giraffe.islamy.models.ArSuras
import com.giraffe.islamy.models.SurahModel

class QuranFragment : Fragment(),SurahAdapter.OnSurahClickListener {
    private lateinit var surah: List<SurahModel>
    private lateinit var rvSurah: RecyclerView
    private lateinit var adapter: SurahAdapter
    private lateinit var btnSwitchMode:Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSwitchMode = view.findViewById(R.id.btn_switch_mode)
        surah = ArSuras.mapIndexed { index, s -> SurahModel(index+1, s) }
        rvSurah = view.findViewById(R.id.rv_surah)
        adapter = SurahAdapter(surah,this)
        rvSurah.adapter = adapter
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES){
            btnSwitchMode.text = "light mode"
        }else{
            btnSwitchMode.text = "dark mode"
        }
        btnSwitchMode.setOnClickListener {
            if (btnSwitchMode.text == "dark mode"){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                btnSwitchMode.text = "light mode"
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                btnSwitchMode.text = "dark mode"
            }
        }


    }

    override fun onSurahClick(surah: SurahModel, position: Int) {
        val intent = Intent(requireActivity(),SurahDetailsActivity::class.java)
        intent.putExtra(Constants.SURAH_NAME_KEY,surah.name)
        intent.putExtra(Constants.SURAH_INDEX_KEY,surah.index)
        startActivity(intent)
        //Toast.makeText(context,"${position+1}->${surah.name}",Toast.LENGTH_LONG).show()
    }
}