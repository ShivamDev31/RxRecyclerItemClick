package com.shivamdev.rxrecycleritemclick

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.Toast
import io.reactivex.disposables.Disposable

class MainActivity : AppCompatActivity() {

    private val adapter = ListAdapter()
    private var subscribe: Disposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()

        setupItemClick()
    }

    private fun setupRecyclerView() {
        val rvList = findViewById(R.id.rv_list) as RecyclerView
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = adapter
    }

    private fun setupItemClick() {
        subscribe = adapter.getClickListener()
                .subscribe({
                    Toast.makeText(this, "Clicked on $it", Toast.LENGTH_LONG).show()
                })
    }

    override fun onDestroy() {
        super.onDestroy()
        subscribe?.dispose()
    }
}