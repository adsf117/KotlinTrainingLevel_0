package com.puzzlebench.trainingkotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycle.layoutManager = GridLayoutManager(this, 2) as RecyclerView.LayoutManager?
        recycle.adapter = ItemAdapter(getItems()) { item ->
            val intent = Intent (this, DetailActivity :: class.java)
            intent.putExtra(DetailActivity.EXTRA_ID,item.id)
            startActivity(intent)
        }


    }
}
