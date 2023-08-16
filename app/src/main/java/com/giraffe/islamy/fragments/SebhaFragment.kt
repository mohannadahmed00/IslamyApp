package com.giraffe.islamy.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.giraffe.islamy.R

class SebhaFragment : Fragment() {
    val tasbehList = listOf(
        "سبحان الله",
        "الحمد لله",
        "الله أكبر",
        "لا حول ولا قوة إلا بالله",
        "لا إله إلا الله"
    )
    private lateinit var ivSebha: ImageView
    private lateinit var tvTypeTasbeh: TextView
    private lateinit var tvNumTasbeh: TextView
    private var numOfTasbeh = 0
    private var indexOfTasbeh = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ivSebha = view.findViewById(R.id.iv_sebha)
        tvTypeTasbeh = view.findViewById(R.id.tv_type_tasbeh)
        tvNumTasbeh = view.findViewById(R.id.iv_play)
        tvTypeTasbeh.text = tasbehList[indexOfTasbeh]
        tvNumTasbeh.text = numOfTasbeh.toString()
        ivSebha.setOnClickListener {
            numOfTasbeh++
            if (numOfTasbeh > 33) {
                numOfTasbeh = 0
                indexOfTasbeh++
                if (indexOfTasbeh > tasbehList.size - 1) {
                    indexOfTasbeh = 0
                }
            }
            tvTypeTasbeh.text = tasbehList[indexOfTasbeh]
            tvNumTasbeh.text = numOfTasbeh.toString()
        }

    }
}