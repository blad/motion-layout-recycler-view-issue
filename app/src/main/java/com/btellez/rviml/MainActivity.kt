package com.btellez.rviml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configure(
            rv = findViewById<RecyclerView>(R.id.recycler_view_vertical),
            horizontal = false
        )

        configure(
            rv = findViewById<RecyclerView>(R.id.recycler_view_horizontal),
            horizontal = true
        )
    }

    private fun configure(rv: RecyclerView, horizontal: Boolean): RecyclerView {
        val adapter = object : RecyclerView.Adapter<SimpleViewHolder>() {
            override fun getItemViewType(position: Int): Int =
                if (horizontal) R.layout.row_single_item_horizontal
                else R.layout.row_single_item

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
                return SimpleViewHolder(view)
            }

            override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
                // No Op. No data needs to be updated in this example.
            }

            override fun getItemCount(): Int = 20
        }

        rv.adapter = adapter
        val orientation = if (horizontal) RecyclerView.HORIZONTAL else RecyclerView.VERTICAL
        rv.layoutManager = LinearLayoutManager(this, orientation, false)
        return rv
    }


    class SimpleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }
}