package com.honey.attendanceproject.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.honey.attendanceproject.R

internal class DetailAdapter(private val context: Context) : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {


    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_detail,parent,false)
        return DetailViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 7
    }

    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}