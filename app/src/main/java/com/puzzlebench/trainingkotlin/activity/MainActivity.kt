package com.puzzlebench.trainingkotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.puzzlebench.trainingkotlin.Item
import com.puzzlebench.trainingkotlin.R
import com.puzzlebench.trainingkotlin.adapter.ItemAdapter
import com.puzzlebench.trainingkotlin.data.ItemProvider
import com.puzzlebench.trainingkotlin.extension.showToast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {
    private val SELECTED_MESSAGE = "selected"
    var adapter = ItemAdapter { item -> goToDetailActivity(item) }
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

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.city_filter__menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val filterItems: FilterItems =
                when (item.itemId) {
                    R.id.filter_photos -> FilterItems.ByType(Item.Type.PHOTO)
                    R.id.filter_videos -> FilterItems.ByType(Item.Type.VIDEO)
                    else -> FilterItems.None
                }
        filterItemsByType(filterItems)
        return super.onOptionsItemSelected(item)
    }

    private fun goToDetailActivity(item: Item) {
        showToast(String.format(resources.getString(R.string.selected_message), item.title), Toast.LENGTH_LONG)
        startActivity<DetailActivity>(DetailActivity.EXTRA_ID to item.id)
    }

    fun filterItemsByType(filterItems: FilterItems) {
        ItemProvider.dataAsyc { items ->
            adapter.items =
                    when (filterItems) {
                        FilterItems.None -> items
                        is FilterItems.ByType -> items.filter { it.type == filterItems.type }
                    }
        }
    }

    sealed class FilterItems {
        object None : FilterItems() // we use a object because do noting
        class ByType(val type: Item.Type) : FilterItems()
    }
}
