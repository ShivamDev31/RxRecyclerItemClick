package com.shivamdev.rxrecycleritemclick

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

/**
 * Created by shivam on 22/6/17.
 */
class ListAdapter : RecyclerView.Adapter<ListAdapter.ListHolder>() {

    private val clickSubject = PublishSubject.create<String>()

    private val items = listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7",
            "Item 8", "Item 9", "Item 10")

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ListHolder(view)
    }

    fun getClickListener(): Observable<String> {
        return clickSubject
    }

    inner class ListHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var itemText = itemView.findViewById(R.id.tv_item_text) as TextView

        init {
            itemView.setOnClickListener { _ ->
                clickSubject.onNext(items[layoutPosition])
            }
        }

        fun bind(text: String) {
            itemText.text = text
        }

    }
}