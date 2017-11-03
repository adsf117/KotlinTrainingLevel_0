package com.puzzlebench.trainingkotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.puzzlebench.trainingkotlin.Item
import com.puzzlebench.trainingkotlin.R
import com.puzzlebench.trainingkotlin.data.ItemProvider
import com.puzzlebench.trainingkotlin.extension.getImageByUrl
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {


    companion object {
        val EXTRA_ID = "EXTRA_ID.ITEM_ID"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val id = intent.getLongExtra(EXTRA_ID, -1)
        ItemProvider.dataAsyc {
            it.firstOrNull { it.id == id }?.let { item ->
                supportActionBar!!.title = item.title
                detail_video_indicator.visibility = when (item.type) {
                    Item.Type.PHOTO -> View.GONE
                    Item.Type.VIDEO -> View.VISIBLE

                }
                detail_image.getImageByUrl(item.imageUrl)
            }


        }
    }
}
