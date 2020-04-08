package com.example.shoppinglist

import android.system.Os.bind
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingAdapter(private val shoppingList: List<ShoppingItem>, private val callBack: ShoppingInteractionCallBack) :RecyclerView.Adapter<ShoppingAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,
            parent,false)
        return ShoppingViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
    val currentItem = shoppingList[position]
       // val item = [position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2

        holder.apply {
            //bind(item)
            itemView.setOnClickListener{
                callBack.onclick(currentItem)

        }}
    }

    override fun getItemCount() = shoppingList.size


    class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.image_laptop
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2
    }
}