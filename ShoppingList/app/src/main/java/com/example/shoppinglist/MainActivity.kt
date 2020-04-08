package com.example.shoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ShoppingInteractionCallBack {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val shoppingList = generateDummyList(5)
        recycler_view.adapter = ShoppingAdapter(shoppingList, this)
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }

    private fun generateDummyList(size: Int): List<ShoppingItem>{
        val list = ArrayList<ShoppingItem>()

        for (i in 0 until size){
            val drawable = when (i % 5){
                0 -> R.drawable.ic_laptop
                1 -> R.drawable.ic_headset
                2 -> R.drawable.ic_phone_iphone
                3 -> R.drawable.ic_watch
                else -> R.drawable.ic_wallpaper
            }
            val item = ShoppingItem(drawable, "Item $i", "Line 2")
            list  += item
        }
        return list
    }

    override fun onclick(item: ShoppingItem) {
        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show()
        val intent = Intent( this, SecondActivity::class.java).apply { this
        putExtra("data", item)}

        startActivity(intent)
    }
}
