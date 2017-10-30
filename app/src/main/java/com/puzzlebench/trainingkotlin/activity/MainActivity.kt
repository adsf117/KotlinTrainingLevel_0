package com.puzzlebench.trainingkotlin.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import com.puzzlebench.trainingkotlin.R
import com.puzzlebench.trainingkotlin.adapter.ItemAdapter
import com.puzzlebench.trainingkotlin.data.getItems
import com.puzzlebench.trainingkotlin.extension.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycle.layoutManager = GridLayoutManager(this, 2)
        recycle.adapter = ItemAdapter(getItems()) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_ID, it.id)
            startActivity(intent)
            showToast("selected  ${it.title}", Toast.LENGTH_LONG) //eg String Templates
        }


    }
}
