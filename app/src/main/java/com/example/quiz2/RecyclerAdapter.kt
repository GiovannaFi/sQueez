package com.example.quiz2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    val list: List<RecyclerElement>,
    val onClick: (RecyclerElement?) -> Unit
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val element = list.getOrNull(position)
        holder.itemTitle.text = holder.itemTitle.context.getText(element!!.title)
        holder.itemDetail.text =
            holder.itemTitle.context.getText(element.details)

        holder.itemView2.setOnClickListener {
            onClick.invoke(element)
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(val itemView2: View) : RecyclerView.ViewHolder(itemView2) {
        var itemTitle: TextView = itemView2.findViewById(R.id.item_title)
        var itemDetail: TextView = itemView2.findViewById(R.id.item_detail)


    }
}
//se non metto val/var quell'elemento sarà visibile solo nell'init, se lo metto sarà accessibile in generale

data class RecyclerElement(
    val title: Int,
    val details: Int,
    val key: String
)
