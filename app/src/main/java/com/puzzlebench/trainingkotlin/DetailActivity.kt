package com.puzzlebench.trainingkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.view_item.*

class DetailActivity : AppCompatActivity() {


    companion object {
        val EXTRA_ID = "EXTRA_ID.ITEM_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val id = intent.getLongExtra(EXTRA_ID, -1)
        val item = getItems().firstOrNull { it.id == id }
        if (item != null) {
            item_title.text = item.title
            item_image.loadUrl(item.url)
        }
    }
}
