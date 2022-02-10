package com.ndup_esiee.myfirstapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logLifeCycle("onCreate")

        val names = listOf("Nico", "Pierre", "Paul", "Jacques", "Alex")
            .sortedBy { it.count() }
            .also { names ->
                Log.i("Question 6", "names=$names")
                tv_names.text = names.toString()
            }

        btn_try_me.setOnClickListener { tv_title.text = names.random() }
    }

    override fun onStart() {
        super.onStart()
        logLifeCycle("onStart")
    }

    override fun onResume() {
        super.onResume()
        logLifeCycle("onResume")
    }

    override fun onStop() {
        super.onStop()
        logLifeCycle("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifeCycle("onDestroy")
    }

    override fun onPause() {
        super.onPause()
        logLifeCycle("onPause")
    }

    private fun logLifeCycle(tag: String) {
        Log.d("LifeCycleEvent", tag)
        tv_lifeCycle.text = "${tv_lifeCycle.text}$tag -> "
    }
}