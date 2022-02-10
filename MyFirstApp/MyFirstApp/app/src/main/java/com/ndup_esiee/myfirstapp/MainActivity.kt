package com.ndup_esiee.myfirstapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_try_me.setOnClickListener { tv_title.text = "${tv_title.text}E" }

        listOf("Nico", "Pierre", "Paul", "Jacques", "Alex")
            .sortedBy { it.count() }
            .let { names ->
                Log.i("Question 6", "names=$names")
                tv_names.text = names.toString()
            }

    }
}