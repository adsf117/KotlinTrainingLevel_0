package com.puzzlebench.trainingkotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.puzzlebench.trainingkotlin.Item
import com.puzzlebench.trainingkotlin.R
import com.puzzlebench.trainingkotlin.adapter.ItemAdapter
import com.puzzlebench.trainingkotlin.data.ItemProvider
import com.puzzlebench.trainingkotlin.extension.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var adapter = ItemAdapter { showToast(it.title) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar.visibility = View.VISIBLE
        ItemProvider.dataAsyc { data ->
            adapter.items = data
            progressBar.visibility = View.GONE
        }
        recycle.layoutManager = GridLayoutManager(this, 2)
        recycle.adapter = adapter
        /*ItemAdapter(getItems()) {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(DetailActivity.EXTRA_ID, it.id)
            startActivity(intent)
            showToast("selected  ${it.title}", Toast.LENGTH_LONG) //eg String Templates
        }*/

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.city_filter__menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        ItemProvider.dataAsyc { items ->
            adapter.items =
                    when (item.itemId) {
                        R.id.filter_all -> items
                        R.id.filter_photos -> items.filter { it.type == Item.Type.PHOTO }
                        R.id.filter_videos -> items.filter { it.type == Item.Type.VIDEO }
                        else -> emptyList()
                    }
        }
        return super.onOptionsItemSelected(item)
    }
}
