package com.shivamdev.rxrecycleritemclick

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import io.reactivex.subjects.PublishSubject

/**
 * Created by shivam on 22/6/17.
 */

class TestAdapter : RecyclerView.Adapter<TestAdapter.MyHolder>() {

    private val click = PublishSubject.create<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder? {
        return null
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        Toast.makeText(holder.itemView.context, "Hello", Toast.LENGTH_SHORT).show()
    }

    override fun getItemCount(): Int {
        return 0
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {

            click.onNext("hello")
        }
    }
}
