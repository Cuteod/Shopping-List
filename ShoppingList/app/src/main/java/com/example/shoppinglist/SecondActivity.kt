package com.example.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class SecondActivity : AppCompatActivity() {
    private lateinit var item: ShoppingItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        item = intent.getSerializableExtra("data") as ShoppingItem

        Toast.makeText(this, item.toString(), Toast.LENGTH_SHORT).show()
    }
}
